const Koa = require('koa');
const app = new Koa();

app.use(ctx => {
  ctx.body = 'hi koa';
})

app.listen(4000, () => {
  console.log("listen this");
})