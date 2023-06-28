import Router from 'koa-router';

const router = new Router();

router.post('/signup', UserController.signup);
router.post('/login', UserController.login);
router.get('/logout', UserController.logout);

export default router;