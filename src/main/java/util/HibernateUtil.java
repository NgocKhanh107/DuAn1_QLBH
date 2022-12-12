package util;

import entity.Ban;
import entity.DanhMuc;
import entity.DonHang;
import entity.DonHangChiTiet;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.KhuVuc;
import entity.KhuyenMai;
import entity.MonAn;
import entity.NhanVien;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory FACTORY;

    static {
        Properties prop = getProperties();

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(prop).build();
        Configuration conf = getConfiguration(prop);
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }

    public static Properties getProperties() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;"
                + "databaseName=QLNhaHang;encrypt=true;trustServerCertificate=true;");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");

        //gen DB tự động
//        properties.put(Environment.HBM2DDL_AUTO, "create");
        return properties;
    }

    public static Configuration getConfiguration(Properties prop) {
        Configuration conf = new Configuration();
        conf.setProperties(prop);

        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(KhuVuc.class);
        conf.addAnnotatedClass(Ban.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(DanhMuc.class);
        conf.addAnnotatedClass(MonAn.class);
        conf.addAnnotatedClass(DonHang.class);
        conf.addAnnotatedClass(DonHangChiTiet.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);

        return conf;
    }
}
