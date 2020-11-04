import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class DBConnection {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;

    private static final String url = "jdbc:mysql://127.0.0.1/db_with_java?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String username = "root";
    private static final String password = "root";

    static {
        config.setJdbcUrl( url );
        config.setUsername( username );
        config.setPassword( password );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        dataSource = new HikariDataSource( config );
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
