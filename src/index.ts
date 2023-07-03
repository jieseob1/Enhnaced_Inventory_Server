import Koa from 'koa';
import session from 'koa-session'
import cors from 'koa-cors';
import bodyParser from 'koa-bodyparser';
import Router from 'koa-router';
import routes from './routes/routes';
import AppDataSource from '../data-source';
const app = new Koa();
// bodyParser, cors
app.use(bodyParser());
app.use(cors());

//Session Setting
// app.keys = ['my-secret-key'];
// app.use(session(app));


const router = new Router(); // router instance
require('dotenv').config();

// https://velog.io/@baer2000/Koa%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-%EC%9B%B9-%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED%81%AC-%EA%B8%B0%EB%B3%B8-Rest-API



AppDataSource.initialize()
  .then(() => {
    const port = process.env.APPLICATION_PORT;
    app.listen(port, () => {
      console.log(`Server is running on port ${port}`);
    });
  })
  .catch((error) => {
    console.log('Data Source initialization error:', error);
  });


app.use(ctx => {
  ctx.body = 'hi koa';
})


// app.use(router.routes()); // Use the routes defined using the router
// app.use(router.allowedMethods());
app.use(router.routes()).use(router.allowedMethods());
