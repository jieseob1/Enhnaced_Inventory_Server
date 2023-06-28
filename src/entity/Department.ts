import {Column, Entity,PrimaryGeneratedColumn} from 'typeorm';


@Entity()
export class Department {
  @PrimaryGeneratedColumn()
  id: string
  @Column()
  name: string
  @Column()
  manager_id: string
}