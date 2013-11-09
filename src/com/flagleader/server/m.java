package com.flagleader.server;

import com.flagleader.engine.RuleEngine;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.RuleEngineInfo;
import com.flagleader.engine.RuleLogList;
import com.flagleader.engine.impl.AbstractRuleEngine;
import com.flagleader.repository.d.u;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.util.DateUtil;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.GCPub;
import com.flagleader.util.StringUtil;
import com.flagleader.util.TempID;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.SerializationUtils;

public class m extends Thread
{
  private boolean c = false;
  Thread a = null;

  public m(RuleExecuteInfo paramRuleExecuteInfo, Thread paramThread)
  {
    this.a = paramThread;
  }

  public void run()
  {
    EngineLogger.getSqlLogger().info(u.a("ruleexecutestart.RuleExecuteInfo", new String[] { RuleExecuteInfo.access$0(this.b), this.b.getPlanInfo() }));
    try
    {
      do
      {
        if (RuleExecuteInfo.access$2(this.b))
        {
          b();
          RuleExecuteInfo.access$3(this.b, false);
          RuleExecuteInfo.access$4(this.b);
        }
        if (!RuleExecuteInfo.access$1(this.b))
        {
          switch (RuleExecuteInfo.access$5(this.b))
          {
          case 0:
            c();
            break;
          case 1:
            d();
            break;
          case 2:
            e();
            break;
          case 3:
            f();
            break;
          case 4:
            g();
            break;
          case 5:
            h();
            break;
          case 6:
          }
          if ((RuleExecuteInfo.access$5(this.b) == 6) && (i()))
            break;
        }
        if (((RuleExecuteInfo.access$1(this.b)) && (!RuleExecuteInfo.access$2(this.b))) || (this.a == null))
          break;
      }
      while (this.a.isAlive());
    }
    catch (Throwable localThrowable)
    {
      EngineLogger.getSqlLogger().error("exception thread" + this.b.getDisplayName() + localThrowable.getMessage(), localThrowable);
    }
    this.c = true;
    RuleExecuteInfo.access$6(this.b, 3);
    EngineLogger.getSqlLogger().info(u.a("ruleexecutestop.RuleExecuteInfo", new String[] { RuleExecuteInfo.access$0(this.b) }));
    RuleExecuteInfo.access$4(this.b);
    super.run();
  }

  private String a(RuleEngine paramRuleEngine)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    String[] arrayOfString = paramRuleEngine.getOutputVariables();
    for (int i = 0; i < arrayOfString.length; i++)
    {
      String str = arrayOfString[i];
      Object localObject = paramRuleEngine.get(str);
      if ((!(localObject instanceof String)) && (!(localObject instanceof Number)) && (!(localObject instanceof Date)) && (!(localObject instanceof Boolean)))
        continue;
      localStringBuffer.append(str).append(":").append(StringUtil.stringValue(localObject)).append(";");
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }

  private void b()
  {
    RuleExecuteInfo.access$6(this.b, 1);
    RuleEngineInfo localRuleEngineInfo = null;
    try
    {
      long l = System.nanoTime();
      RuleExecuteInfo.access$7(this.b, System.currentTimeMillis());
      RuleExecuteInfo.access$4(this.b);
      RuleEngine localRuleEngine = RuleEngineFactory.newInstance().getRuleEngine();
      if (this.b.getTracelogtype() == 1)
        localRuleEngine.put("ruleLog", new RuleLogList());
      localRuleEngineInfo = new RuleEngineInfo((AbstractRuleEngine)localRuleEngine, RuleExecuteInfo.access$0(this.b), true);
      ExecuteInfos.addRecord(localRuleEngineInfo);
      Object localObject1;
      for (int i = 0; i < RuleExecuteInfo.access$8(this.b).size(); i++)
      {
        localObject1 = (AdvancedProperty)RuleExecuteInfo.access$8(this.b).get(i);
        localRuleEngine.put(((AdvancedProperty)localObject1).getKey(), ((AdvancedProperty)localObject1).getProperty());
      }
      localRuleEngine.excute(RuleExecuteInfo.access$0(this.b));
      RuleExecuteInfo.access$9(this.b, System.nanoTime() - l);
      RuleExecuteInfo.access$10(this.b, "");
      RuleExecuteInfo tmp193_190 = this.b;
      RuleExecuteInfo.access$12(tmp193_190, RuleExecuteInfo.access$11(tmp193_190) + 1L);
      if (this.b.getTracelogtype() == 1)
      {
        RuleLogList localRuleLogList = (RuleLogList)localRuleEngine.get("ruleLog");
        if ((localRuleLogList != null) && (localRuleLogList.hasChild()))
        {
          localObject1 = new File(FileUtil.getCurrentDir() + File.separator + "logs" + File.separator + RuleExecuteInfo.access$0(this.b), TempID.newShortTempID() + ".rlg");
          if (!((File)localObject1).getParentFile().exists())
            ((File)localObject1).getParentFile().mkdirs();
          SerializationUtils.serialize(localRuleLogList, new FileOutputStream((File)localObject1));
        }
      }
    }
    catch (Exception localException)
    {
      RuleExecuteInfo.access$10(this.b, localException.getMessage());
      EngineLogger.getSqlLogger().error(RuleExecuteInfo.access$0(this.b) + localException.getMessage());
    }
    finally
    {
      RuleExecuteInfo.access$6(this.b, 2);
      if (localRuleEngineInfo != null)
        ExecuteInfos.removeRecord(localRuleEngineInfo);
    }
  }

  private void c()
  {
    b();
    RuleExecuteInfo.access$14(this.b, System.currentTimeMillis() + RuleExecuteInfo.access$13(this.b));
    if (System.currentTimeMillis() - RuleExecuteInfo.access$15(this.b) > RuleExecuteInfo.access$16(this.b))
      RuleExecuteInfo.access$17(this.b, System.currentTimeMillis() - RuleExecuteInfo.access$15(this.b));
    RuleExecuteInfo.access$4(this.b);
    try
    {
      sleep(RuleExecuteInfo.access$13(this.b));
    }
    catch (Exception localException)
    {
      EngineLogger.getSqlLogger().error("error sleep thread" + this.b.getDisplayName() + localException.getMessage(), localException);
    }
  }

  private void d()
  {
    if (System.currentTimeMillis() - RuleExecuteInfo.access$15(this.b) > RuleExecuteInfo.access$13(this.b) * 1000L)
    {
      b();
      RuleExecuteInfo.access$14(this.b, System.currentTimeMillis() + RuleExecuteInfo.access$13(this.b) * 1000L);
      RuleExecuteInfo.access$4(this.b);
      try
      {
        sleep(1000L);
      }
      catch (Exception localException)
      {
      }
    }
  }

  private void e()
  {
    long l1 = Long.parseLong(new SimpleDateFormat("yyyyMMddHH").format(new Date()));
    long l2 = Long.parseLong(new SimpleDateFormat("yyyyMMddHH").format(new Date(RuleExecuteInfo.access$15(this.b))));
    long l3 = Long.parseLong(new SimpleDateFormat("mmss").format(new Date()));
    long l4 = 0L;
    if (!StringUtil.isEmpty(RuleExecuteInfo.access$18(this.b)))
      l4 = Long.parseLong(GCPub.getNumber(RuleExecuteInfo.access$18(this.b)));
    if ((l1 - l2 >= RuleExecuteInfo.access$13(this.b)) && (l3 >= l4))
    {
      b();
      RuleExecuteInfo.access$14(this.b, System.currentTimeMillis() + RuleExecuteInfo.access$13(this.b) * 1000L * 60L * 60L);
      RuleExecuteInfo.access$4(this.b);
      try
      {
        sleep(1000L);
      }
      catch (Exception localException)
      {
      }
    }
  }

  private void f()
  {
    long l1 = Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(new Date()));
    long l2 = Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(new Date(RuleExecuteInfo.access$15(this.b))));
    long l3 = Long.parseLong(new SimpleDateFormat("HHmmss").format(new Date()));
    long l4 = 0L;
    if (!StringUtil.isEmpty(RuleExecuteInfo.access$18(this.b)))
      l4 = Long.parseLong(GCPub.getNumber(RuleExecuteInfo.access$18(this.b)));
    if ((l1 - l2 >= RuleExecuteInfo.access$13(this.b)) && (l3 >= l4))
    {
      b();
      RuleExecuteInfo.access$14(this.b, System.currentTimeMillis() + RuleExecuteInfo.access$13(this.b) * 1000L * 60L * 60L * 24L);
      RuleExecuteInfo.access$4(this.b);
      try
      {
        sleep(1000L);
      }
      catch (Exception localException)
      {
      }
    }
  }

  private void g()
  {
    Date localDate = new Date();
    long l1 = Long.parseLong(new SimpleDateFormat("yyyy").format(localDate)) * 100L + DateUtil.getWeekOfYear(localDate);
    long l2 = Long.parseLong(new SimpleDateFormat("yyyy").format(new Date(RuleExecuteInfo.access$15(this.b)))) * 100L + DateUtil.getWeekOfYear(new Date(RuleExecuteInfo.access$15(this.b)));
    long l3 = Long.parseLong(new SimpleDateFormat("HHmmss").format(localDate));
    long l4 = 0L;
    if (!StringUtil.isEmpty(RuleExecuteInfo.access$18(this.b)))
      l4 = Long.parseLong(GCPub.getNumber(RuleExecuteInfo.access$18(this.b)));
    int i = DateUtil.getDayOfWeek(localDate);
    if ((l1 - l2 >= RuleExecuteInfo.access$13(this.b)) && (i == Integer.parseInt(RuleExecuteInfo.access$19(this.b))) && (l3 >= l4))
    {
      b();
      RuleExecuteInfo.access$14(this.b, System.currentTimeMillis() + RuleExecuteInfo.access$13(this.b) * 1000L * 60L * 60L * 24L * 7L);
      RuleExecuteInfo.access$4(this.b);
      try
      {
        sleep(1000L);
      }
      catch (Exception localException)
      {
      }
    }
  }

  private void h()
  {
    Date localDate = new Date();
    int i = Integer.parseInt(new SimpleDateFormat("yyyyMM").format(localDate));
    int j = Integer.parseInt(new SimpleDateFormat("yyyyMM").format(new Date(RuleExecuteInfo.access$15(this.b))));
    long l1 = Long.parseLong(new SimpleDateFormat("HHmmss").format(localDate));
    long l2 = 0L;
    if (!StringUtil.isEmpty(RuleExecuteInfo.access$18(this.b)))
      l2 = Long.parseLong(GCPub.getNumber(RuleExecuteInfo.access$18(this.b)));
    int k = 1;
    if (!StringUtil.isEmpty(RuleExecuteInfo.access$19(this.b)))
      k = Integer.parseInt(GCPub.getNumber(RuleExecuteInfo.access$19(this.b)));
    int m = DateUtil.getDayOfWeek(localDate);
    if ((i - j >= RuleExecuteInfo.access$13(this.b)) && (m == k) && (l1 >= l2))
    {
      b();
      try
      {
        RuleExecuteInfo.access$14(this.b, new SimpleDateFormat("yyyyMMdd HHmmss").parse(String.valueOf(DateUtil.nextYearMonth(i) * 100 + m) + " " + String.valueOf(l2)).getTime());
      }
      catch (Exception localException1)
      {
      }
      RuleExecuteInfo.access$4(this.b);
      try
      {
        sleep(1000L);
      }
      catch (Exception localException2)
      {
      }
    }
  }

  private boolean i()
  {
    if ((RuleExecuteInfo.access$19(this.b).length() > 0) && (RuleExecuteInfo.access$18(this.b).length() > 0))
    {
      Date localDate = new Date();
      long l1 = Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(localDate));
      long l2 = Long.parseLong(new SimpleDateFormat("HHmmss").format(localDate));
      long l3 = 0L;
      if (!StringUtil.isEmpty(RuleExecuteInfo.access$18(this.b)))
        l3 = Long.parseLong(GCPub.getNumber(RuleExecuteInfo.access$18(this.b)));
      long l4 = 0L;
      if (!StringUtil.isEmpty(RuleExecuteInfo.access$19(this.b)))
        l4 = Long.parseLong(GCPub.getNumber(RuleExecuteInfo.access$19(this.b)));
      if ((l1 == l4) && (l2 == l3))
      {
        b();
        RuleExecuteInfo.access$14(this.b, RuleExecuteInfo.access$15(this.b));
        RuleExecuteInfo.access$4(this.b);
        return true;
      }
      return l1 * 1000000L + l2 > l4 * 1000000L + l3;
    }
    if (RuleExecuteInfo.access$13(this.b) > 0L)
      try
      {
        sleep(RuleExecuteInfo.access$13(this.b) * 1000L);
      }
      catch (Exception localException)
      {
      }
    b();
    RuleExecuteInfo.access$14(this.b, RuleExecuteInfo.access$15(this.b));
    RuleExecuteInfo.access$4(this.b);
    return true;
  }

  public boolean a()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.m
 * JD-Core Version:    0.6.0
 */