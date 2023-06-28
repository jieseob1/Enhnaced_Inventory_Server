import { Column, Entity, PrimaryColumn, PrimaryGeneratedColumn,ManyToOne} from "typeorm";
import { Department } from "./Department";
// initialization
@Entity() // table name
export class User {
  @PrimaryGeneratedColumn("uuid") //universally unique id
  id: number

  @Column('text') // column types => database type specific
  firstName: string

  @Column('text')
  lastName: string

  // @Column('boolean')
  // isActive: boolean

  @Column("text")
  email!: string

  @Column("timestamptz")
  createdAt!: Date

  // @ManyToOne(() => Department, department => department.users)
  // department: Department;
}