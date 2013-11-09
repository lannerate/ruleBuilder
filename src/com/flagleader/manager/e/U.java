package com.flagleader.manager.e;

import com.flagleader.a.A;
import com.flagleader.a.B;
import com.flagleader.a.ak;
import com.flagleader.a.y;
import com.flagleader.a.z;
import com.flagleader.db.Sheet;
import com.flagleader.engine.IRuleLog;
import com.flagleader.engine.RuleEngine;
import com.flagleader.engine.RuleEngineClassLoader;
import com.flagleader.engine.RuleEngineException;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.RuleLogList;
import com.flagleader.engine.impl.RuleRecordServer;
import com.flagleader.excel.IExcelBook;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.t;
import com.flagleader.repository.d.a;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.sql.DBConnection;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.Writer;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.SystemUtils;

public class U extends W
{
  protected IRuleClass a;
  private HashMap k = new HashMap();
  private List l = new ArrayList();
  private IRuleLog m;
  private List n;
  long b = 0L;
  private Writer o = null;
  private HashMap p = null;

  public U(IRuleClass paramIRuleClass, Writer paramWriter, HashMap paramHashMap)
  {
    super(paramIRuleClass);
    this.o = paramWriter;
    this.p = paramHashMap;
    this.a = paramIRuleClass;
  }

  protected void a(String paramString)
  {
    try
    {
      RuleEngineClassLoader localRuleEngineClassLoader = RuleEngineFactory.getInstance(this.a.getCompilePackage().getUuid()).getClassLoader();
      localRuleEngineClassLoader.addResourceFile(new File(this.a.getCompilePackage().getCompilePath()));
      localRuleEngineClassLoader.addResourceFile(new File(this.a.getCompilePackage().getExportDirPath()));
      localRuleEngineClassLoader.addResourceFiles(this.a.getCompilePackage().getClassPaths());
      localRuleEngineClassLoader.addResourceFiles(this.a.getCompilePackage().getEnvionment().getClassDirs());
      localRuleEngineClassLoader.addResourceFile(new File(SystemUtils.JAVA_IO_TMPDIR));
      localRuleEngineClassLoader.addResourceFiles(a.d());
      RuleEngineFactory.newInstance().getClassLoader().addResourceFile(new File(this.a.getCompilePackage().getCompilePath()));
      RuleEngineFactory.newInstance().getClassLoader().addResourceFile(new File(SystemUtils.JAVA_IO_TMPDIR));
      RuleEngineFactory.newInstance().getClassLoader().addResourceFiles(this.a.getCompilePackage().getClassPaths());
      RuleEngineFactory.newInstance().getClassLoader().addResourceFiles(this.a.getCompilePackage().getEnvionment().getClassDirs());
      RuleEngineFactory.newInstance().getClassLoader().addResourceFiles(a.d());
      RuleRecordServer.clearUnused();
    }
    catch (Exception localException1)
    {
      EngineLogger.getEngineLogger().info(localException1.getLocalizedMessage(), localException1);
    }
    if (b.a().G())
    {
      localObject1 = new File("trace");
      if (((File)localObject1).exists())
        FileUtil.deleteAllFilesThenDirectories((File)localObject1, false);
    }
    this.k.clear();
    this.l.clear();
    this.k.put("out", this.o);
    if (b.a().G())
    {
      this.m = new RuleLogList();
      this.k.put("ruleLog", this.m);
    }
    this.n = new LinkedList();
    this.k.put("snapShot", this.n);
    if (n().a().a() != null)
      this.k.put("runUserId", n().a().a());
    Object localObject1 = this.a.getEnvionment().getAllTestVariable();
    Object localObject4;
    Object localObject6;
    Object localObject8;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof MappingVariable))
      {
        localObject3 = (MappingVariable)localObject2;
        if (c(((MappingVariable)localObject3).getValueName()) == null)
          continue;
        localObject4 = this.a.getEnvionment().getTypeManager().a(((MappingVariable)localObject3).getValueType()).f(c(((MappingVariable)localObject3).getValueName()).toString());
        this.k.put(((MappingVariable)localObject3).getValueName(), localObject4);
      }
      else if (((localObject2 instanceof BusinessObjectClass)) && (!(localObject2 instanceof FunctionClass)))
      {
        localObject3 = ((BusinessObjectClass)localObject2).getClazz();
        localObject4 = d(((BusinessObjectClass)localObject2).getClassName());
        Object localObject5 = ((Class)localObject4).newInstance();
        localObject6 = ((B)localObject3).m().a();
        String str1 = ((B)localObject3).K();
        while (((z)localObject6).hasNext())
        {
          y localy = (y)((z)localObject6).next();
          int i1 = a((B)localObject3, localy);
          if (i1 <= 0)
            continue;
          localObject8 = localy.N();
          String str2 = localy.e().K();
          Object localObject9 = c(str1 + "." + (String)localObject8);
          if (localObject9 != null)
          {
            com.flagleader.repository.d.r.a(localObject5, (String)localObject8, this.a.getEnvionment().getTypeManager().a(str2).f(localObject9.toString()));
          }
          else
          {
            if (!this.a.getEnvionment().getTypeManager().a(str2).m())
              continue;
            com.flagleader.repository.d.r.a(localObject5, (String)localObject8, "");
          }
        }
        this.l.add(localObject5);
      }
      else if (((localObject2 instanceof SheetTable)) && (!((SheetTable)localObject2).isSaveValue()) && (((SheetTable)localObject2).getTestFile().length() == 0))
      {
        if (c(((SheetTable)localObject2).getValueName()) == null)
          continue;
        this.k.put(((SheetTable)localObject2).getValueName(), c(((SheetTable)localObject2).getValueName()));
      }
      else
      {
        if ((!(localObject2 instanceof TreeValueNode)) || (c(((TreeValueNode)localObject2).getValueName()) == null))
          continue;
        this.k.put(((TreeValueNode)localObject2).getValueName(), c(((TreeValueNode)localObject2).getValueName()));
      }
    }
    Object localObject2 = this.a.getEnvionment().getDBModels();
    Object localObject3 = new ArrayList();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (DBModel)((Iterator)localObject2).next();
      try
      {
        if (this.k.get(((DBModel)localObject4).getValueName()) != null)
          continue;
        this.k.put(((DBModel)localObject4).getValueName(), ((DBModel)localObject4).getConnection());
        ((ArrayList)localObject3).add(localObject4);
      }
      catch (Exception localException3)
      {
      }
    }
    localObject2 = this.a.getEnvionment().getExcelBookModels();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (ExcelBookModel)((Iterator)localObject2).next();
      try
      {
        if ((((ExcelBookModel)localObject4).getXlsFile() == null) || (!new File(((ExcelBookModel)localObject4).getXlsFile()).exists()))
          continue;
        this.k.put(((ExcelBookModel)localObject4).getValueName(), ((ExcelBookModel)localObject4).getXlsFile());
      }
      catch (Exception localException4)
      {
      }
    }
    this.b = System.nanoTime();
    int j;
    DBModel localDBModel;
    try
    {
      localObject4 = RuleEngineFactory.getInstance(this.a.getCompilePackage().getUuid()).getRuleEngine();
      ((RuleEngine)localObject4).putAll(this.k);
      for (int i = 0; i < this.l.size(); i++)
        ((RuleEngine)localObject4).put(this.l.get(i));
      ((RuleEngine)localObject4).excuteNew(this.a.getExeRulePackageName() + paramString);
      o().c(this.a.getDisplayName() + c.a("finish.Test", new String[] { NumberUtil.formatDouble((System.nanoTime() - this.b) / 1000000.0D, "0.00") }));
      this.k.clear();
      this.k.putAll(((RuleEngine)localObject4).getAll());
      this.l.clear();
      this.l.addAll(((RuleEngine)localObject4).getObjects());
      Iterator localIterator = this.a.getEnvionment().getAcceptElements(new V(this));
      while (localIterator.hasNext())
      {
        localObject6 = (SheetTable)localIterator.next();
        ((SheetTable)localObject6).setSheetData((Sheet)this.k.get(((SheetTable)localObject6).getValueName()));
      }
      localIterator = this.a.getEnvionment().getExcelBookModels();
      while (localIterator.hasNext())
      {
        localObject6 = (ExcelBookModel)localIterator.next();
        ((ExcelBookModel)localObject6).setExcelData((IExcelBook)this.k.get(((ExcelBookModel)localObject6).getValueName()));
      }
      System.gc();
    }
    catch (RuleEngineException localRuleEngineException)
    {
      o().a(localRuleEngineException.getMessage());
    }
    catch (Exception localException2)
    {
      o().a(localException2.getMessage());
    }
    finally
    {
      for (j = 0; j < ((ArrayList)localObject3).size(); j++)
      {
        localDBModel = (DBModel)((ArrayList)localObject3).get(j);
        localObject8 = this.k.get(localDBModel.getValueName());
        if (localObject8 != null)
          try
          {
            if (((localObject8 instanceof Connection)) && (!((Connection)localObject8).isClosed()))
              ((Connection)localObject8).close();
            else if ((localObject8 instanceof DBConnection))
              ((DBConnection)localObject8).forceCloseConnection();
          }
          catch (Exception localException7)
          {
            localException7.printStackTrace();
          }
        this.k.remove(localDBModel.getValueName());
      }
    }
  }

  private Object c(String paramString)
  {
    return this.p.get(paramString);
  }

  public HashMap j()
  {
    return this.k;
  }

  public List k()
  {
    return this.l;
  }

  public IRuleLog l()
  {
    return this.m;
  }

  public List m()
  {
    return this.n;
  }

  private Class d(String paramString)
  {
    return RuleEngineFactory.getInstance(this.a.getMainPackage().getUuid()).getClassLoader().loadClass(paramString);
  }

  private int a(B paramB, y paramy)
  {
    if (paramy.l())
      return 1;
    if ((paramy.j()) || (paramy.k()))
      try
      {
        PropertyDescriptor localPropertyDescriptor = PropertyUtils.getPropertyDescriptor(paramB.V().newInstance(), paramy.N());
        if ((PropertyUtils.getReadMethod(localPropertyDescriptor) != null) && (PropertyUtils.getWriteMethod(localPropertyDescriptor) != null))
          return 2;
      }
      catch (Exception localException)
      {
        return 0;
      }
    return 0;
  }

  public String a()
  {
    return c.b("TestTreadInfo.info");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.U
 * JD-Core Version:    0.6.0
 */