import {Context} from 'koa';
import { DataSource} from 'typeorm';
import {User} from '../../../entity/User';
import AppDataSource from '../../../../data-source';
// apply absolute path

const dataSource = AppDataSource;

class UserController {
  async signup(ctx: Context) {
    const {email, password} = ctx.request.body; // request body

    
  }
}