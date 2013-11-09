package com.flagleader.server;

import com.flagleader.db.DBFactory;
import com.flagleader.db.Database;
import com.flagleader.db.Select;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.repository.e.d;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.RulePackage;
import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class b extends Thread
{
  boolean a = false;
  private Database b;
  private Select c;
  private Select d;
  private HashMap e = new HashMap();

  public b()
  {
    try
    {
      this.b = DBFactory.newIntance().getDatabase("rules");
      this.c = this.b.getSelect(new String[] { "ruleid", "rulever", "stime", "exerule", "mainversion" }, new String[] { "ruleid", "rulever", "stime", "exerule", "mainversion" });
      this.c.setResultType(2);
      this.d = this.b.getSelect(new String[] { "rulezip", "stime" }, new String[] { "rulezip", "stime" });
      this.d.setResultType(2);
      if (!new File(Property.getInstance().getRuleEngineClassDir()).exists())
        new File(Property.getInstance().getRuleEngineClassDir()).mkdirs();
      if (this.b.getConnection() == null)
        this.a = true;
    }
    catch (Exception localException)
    {
    }
  }

  public void run()
  {
    while (!this.a)
      try
      {
        this.c.selectWhere("select rv.ruleid,rv.rulever,rv.stime,r.exerule,rm.mainversion  from ( select rv.ruleid,max(rv.stime) as stime,rv.mainversion  from r_ruleversion rv where ( rv.stateid=5 or rv.stateid=7) group by rv.ruleid,rv.mainversion ) rm inner join r_ruleversion rv on rv.ruleid=rm.ruleid and rv.stime=rm.stime inner join r_rule r on rv.ruleid=r.ruleid and r.ruletypeid=4", new Object[0]);
        while (this.c.next())
        {
          String str1 = this.c.getString(4);
          String str2 = this.c.getString(3);
          Timestamp localTimestamp = this.c.getTimestamp(2);
          double d1 = this.c.getDouble(1);
          int i = this.c.getInteger(0);
          Date localDate = (Date)this.e.get(str2 + str1);
          if (localDate == null)
          {
            long l = RuleEngineFactory.getInstance("").getRuleLastModified(str2 + com.flagleader.repository.a.c.a(str1));
            if (l > 0L)
            {
              localDate = new Date(l);
              this.e.put(str2 + com.flagleader.repository.a.c.a(str1), localDate);
            }
          }
          if ((localDate != null) && ((localTimestamp == null) || (localDate.compareTo(localTimestamp) >= 0)))
            continue;
          this.d.selectWhere("select rv.rulezip,rv.stime from r_ruleversion rv  where rv.ruleid= ?  and rv.rulever= ? ", new Object[] { new Integer(i), new Double(d1) });
          if (this.d.next())
          {
            String str3 = this.d.getZipObject(0);
            RulePackage localRulePackage = (RulePackage)new d().load(str3);
            String str4 = m.a().i().b(localRulePackage);
            String str5 = new com.flagleader.repository.a.c().a(Property.getInstance().getRuleEngineClassDir(), "", localRulePackage.getExeRulePackageName(), localRulePackage.getMainVersion(), localRulePackage.getRuleClassName(), str4, true);
            if (str5 != null)
            {
              LogFactory.getLog("ruleengine").error(str5);
              this.b.execute("update r_ruleversion set stateid=8 where ruleid= ? and rulever= ? ", new Object[] { new Integer(i), new Double(d1) });
            }
            else
            {
              this.b.execute("update r_ruleversion set stateid=7 where ruleid= ? and rulever= ? ", new Object[] { new Integer(i), new Double(d1) });
            }
            this.e.put(str2 + str1, localTimestamp);
          }
          this.d.resetValues();
        }
        this.c.resetValues();
        sleep(60000L);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        break;
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.b
 * JD-Core Version:    0.6.0
 */