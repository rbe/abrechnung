package eu.artofcoding.abrechnung.model.jdo;

import eu.artofcoding.abrechnung.model.jdo.DNCustomer;
import org.junit.Test;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class DataNucleusJDOTest {

    @Test
    public void persistJDO() {
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("test");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try {
            tx.begin();
            DNCustomer customer = new DNCustomer();
            customer.setId("DNCUST-1");
            pm.makePersistent(customer);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
    }

}
