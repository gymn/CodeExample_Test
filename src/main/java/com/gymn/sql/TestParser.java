package com.gymn.sql;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;
import org.apache.ibatis.reflection.MetaObject;
import org.junit.Test;

/**
 * @author hunan
 * @date 2019/4/26
 * @time 8:10 PM
 */
public class TestParser {
    @Test
    public void testDruidSqlParser() {
        SQLStatementParser parser = new SQLStatementParser("select id from users order by id,name desc");
        SQLStatement statement = parser.parseStatement();
        SchemaStatVisitor visitor = new SchemaStatVisitor();
        statement.accept(visitor);
        System.out.println(visitor.getOrderByColumns());
    }

    @Test
    public void test2() {
    }
}
