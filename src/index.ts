const Koa = require('koa');
const Router = require('koa-router');

const app = new Koa();
const router = new Router(); // router instance
require('dotenv').config();

import { DataSource } from "typeorm";

const AppDataSource = new DataSource({
  type: "postgres",
  host: process.env.PG_HOST,
  port: parseInt(process.env.PG_PORT, 10),
  username: process.env.PG_USER,
  password: process.env.PG_PASSWORD,
  database: process.env.PG_DATABASE,
  entities: [
    "entity/*.ts"
  ]
})

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
