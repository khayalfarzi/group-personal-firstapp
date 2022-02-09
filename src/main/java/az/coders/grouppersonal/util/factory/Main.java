package az.coders.grouppersonal.util.factory;

public class Main {

    public static void main(String[] args) {

        Sql sql = new MySql();

        sql.con();
        sql.stmt();
        sql.add();

//        PgSql pgSql = new PgSql();
//        pgSql.con();
//        pgSql.stmt();
//        pgSql.add();
//
//        MySql mySql = new MySql();
//        mySql.con();
//        mySql.stmt();
//        mySql.add();
    }
}
