package code.C_14_Inherited

/*
class ParentClass {}
class ChildClass : ParentClass() {} // error

ParentClass에 open이 붙지 않으면 상속을 할 수 없는 final class가 된다.

 */
open class ParentClass {}
class ChildClass : ParentClass() {}