
// https://github.com/typeorm/typeorm
import {
  ConnectionManager,
  getConnectionManager,
  Connection,
  ConnectionOptions,
  createConnection
} from 'typeorm';
import 'pg';

export default class Database {
  connectionManager: ConnectionManager;
}