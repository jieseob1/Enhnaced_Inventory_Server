import {Context} from 'koa';
import {createHash} from 'crypto';
import {User} from '../../../entity/User';
import jwt from 'jsonwebtoken';
import AppDataSource from '../../../../data-source';
// apply absolute path



const dataSource = AppDataSource;
// manager: manage (crud) any entity => 
//entity type을 적용할 수 있는지 확인해보기
const hashPassword = (password: string) => {
  const hash = createHash('sha256');
  hash.update(password);
  return hash.digest('hex');
}

//로그인 시 JWT 토큰 생성
const createToken = (userId: number) => {
  const token = jwt.sign({ userId }, 'your-secret-key', { expiresIn: '1h' });
  return token;
}

class UserController {
  async signup(ctx: Context) {
    //해당 부분 추후에 바꾸기
    const {email, password} = ctx.request.body; // request body

    //repository, 작업이 구체적인 entity로 제한
    const userRepositoy = dataSource.getRepository(User);
    const isDuplicateUser = await userRepositoy.findOne({email});

    if(isDuplicateUser) {
      ctx.status = 409;
      ctx.body= {error: 'User already exists'};
      return;
    }

    const user = userRepositoy.create({email, password});
    await userRepositoy.save(user);

    ctx.body ={message: 'User created successfully'};
  }

  async login(ctx: Context) {
    const { email, password} = 
  }
}