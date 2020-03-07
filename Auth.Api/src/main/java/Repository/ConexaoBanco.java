/*package Repository;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConexaoBanco {
    private BasicDataSource dataSource;


    public ConexaoBanco() {
        this.dataSource = dataSource;
        try {
            dataSource = new BasicDataSource();
           dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource.setUrl("jdbc:sqlserver://srvgrupo.database.windows.net:1433;database=bdgrupo10");
            // quem for acessar do yoshi: localhost -> 10.3.2.180
            // quem for acessar do yoshi: gaga -> gaga-seunome

            dataSource.setUsername("monitoreasy");
            dataSource.setPassword("#Gfgrupo10b"); // ou sua senha

        } catch (Exception ex) {
            //logger vai printar qual é a exceção do erro
            System.out.println(ex);

        }
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}*/
