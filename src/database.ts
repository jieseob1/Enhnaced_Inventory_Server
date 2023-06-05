
// https://github.com/typeorm/typeorm
import {
  ConnectionManager,
  getConnectionManager,
  Connection,
  ConnectionOptions,
  createConnection
} from 'typeorm';
import 'pg';
import AppDataSource from './data-source';
// to connect database part