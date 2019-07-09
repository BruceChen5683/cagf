import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.io.File;

public class SchemaGenerate {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure(new File("/home/battlecall/IdeaProjects/cagf/WebRoot/src/hibernate.cfg.xml"));
        SchemaExport export = new SchemaExport(configuration);
        export.create(true,true);
    }
}
