
import Koa from 'koa';
import Router from 'koa-router'
import { dataSource } from './data-source';

const app = new Koa();
const router = new Router(); // router instance
const serverPort = 4000;

dataSource.initialize()
  .then(() => {
    console.log("Data Source has been initialized");
        // here you can start to work with your database
  })
  .catch((error) => console.log(error))

app.use((ctx,next) => {
  ctx.body = 'hi my koa';
})


// app.use(router.routes()); // Use the routes defined using the router
// app.use(router.allowedMethods());
app.use(router.routes()).use(router.allowedMethods());

app.listen(serverPort, () => {
  console.log("listen this");
})