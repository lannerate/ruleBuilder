package com.flagleader.manager.e;

import com.flagleader.db.Sheet;
import com.flagleader.engine.RuleEngine;
import com.flagleader.engine.RuleEngineClassLoader;
import com.flagleader.engine.RuleEngineException;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.RuleLogList;
import com.flagleader.excel.IExcelBook;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.t;
import com.flagleader.repository.d.s;
import com.flagleader.repository.d.u;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.tree.CheckRuleInfo;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestObjectInfo;
import com.flagleader.sql.DBConnection;
import com.flagleader.util.LangUtil;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.io.Writer;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class N extends W
{
  protected List a = new ArrayList();
  protected Writer b = null;

  public N(CheckRuleInfo paramCheckRuleInfo, Writer paramWriter)
  {
    super(paramCheckRuleInfo);
    this.b = paramWriter;
    this.g = new O(this, paramCheckRuleInfo);
  }

  private CheckRuleInfo j()
  {
    return (CheckRuleInfo)h();
  }

  protected void a(String paramString1, TestCase paramTestCase, String paramString2)
  {
    this.a.add(new H(paramString1, (ITreeNode)j().getParent(), paramString2));
    o().a(j() + " : " + paramString1);
  }

  protected void a(TestCase paramTestCase)
  {
    RuleLogList localRuleLogList = null;
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localHashMap1.put("out", this.b);
    if (b.a().G())
    {
      localRuleLogList = new RuleLogList();
      localHashMap1.put("ruleLog", localRuleLogList);
    }
    LinkedList localLinkedList = new LinkedList();
    localHashMap1.put("snapShot", localLinkedList);
    paramTestCase.getCheckRuleMap().clear();
    localHashMap1.put("ruleCheckMap", paramTestCase.getCheckRuleMap());
    if (n().a().a() != null)
      localHashMap1.put("runUserId", n().a().a());
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator = paramTestCase.getChildrenIterator();
    if (paramTestCase.getChildrenCount() == 0)
      return;
    Object localObject2;
    do
    {
      localObject1 = (TestObjectInfo)localIterator.next();
      if (((TestObjectInfo)localObject1).getClassName().length() > 0)
      {
        localObject2 = localHashMap2.get(((TestObjectInfo)localObject1).getClassName());
        if (localObject2 == null)
          try
          {
            Class localClass = a(paramTestCase, ((TestObjectInfo)localObject1).getClassName());
            localObject2 = localClass.newInstance();
            localHashMap2.put(((TestObjectInfo)localObject1).getClassName(), localObject2);
            localArrayList.add(localObject2);
          }
          catch (Exception localException2)
          {
            a(u.a("notFindClass.error", "can't find the class") + ((TestObjectInfo)localObject1).getClassName(), paramTestCase, ((TestObjectInfo)localObject1).toString() + localException2.getMessage());
            return;
          }
        try
        {
          if (((TestObjectInfo)localObject1).getInitialValue().length() > 0)
          {
            com.flagleader.repository.d.r.a(localObject2, ((TestObjectInfo)localObject1).getAttributeName(), paramTestCase.getTypeManager().a(((TestObjectInfo)localObject1).getType()).f(((TestObjectInfo)localObject1).getInitialValue()));
            continue;
          }
          if (!((TestObjectInfo)localObject1).getJavaType().m())
            continue;
          com.flagleader.repository.d.r.a(localObject2, ((TestObjectInfo)localObject1).getAttributeName(), "");
        }
        catch (s locals)
        {
          a(u.a("runRule.error", "运行指定规则包时出错") + paramTestCase.getRuleSetName(), paramTestCase, locals.getLocalizedMessage() + locals.getCause().getLocalizedMessage());
        }
      }
      else
      {
        if (((TestObjectInfo)localObject1).getInitialValue().length() <= 0)
          continue;
        localObject2 = paramTestCase.getTypeManager().a(((TestObjectInfo)localObject1).getType()).f(((TestObjectInfo)localObject1).getInitialValue());
        localHashMap1.put(((TestObjectInfo)localObject1).getAttributeName(), localObject2);
      }
    }
    while (localIterator.hasNext());
    Object localObject1 = new ArrayList();
    if (paramTestCase.getEnvionment() != null)
    {
      localObject2 = paramTestCase.getEnvionment().getDBModels();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (DBModel)((Iterator)localObject2).next();
        try
        {
          if (localHashMap1.get(((DBModel)localObject3).getValueName()) != null)
            continue;
          localHashMap1.put(((DBModel)localObject3).getValueName(), ((DBModel)localObject3).getConnection());
          ((ArrayList)localObject1).add(localObject3);
        }
        catch (Exception localException3)
        {
        }
      }
      localObject2 = paramTestCase.getEnvionment().getExcelBookModels();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ExcelBookModel)((Iterator)localObject2).next();
        try
        {
          if ((((ExcelBookModel)localObject3).getXlsFile() == null) || (!new File(((ExcelBookModel)localObject3).getXlsFile()).exists()))
            continue;
          localHashMap1.put(((ExcelBookModel)localObject3).getValueName(), ((ExcelBookModel)localObject3).getXlsFile());
        }
        catch (Exception localException4)
        {
        }
      }
    }
    Object localObject4;
    Object localObject5;
    if (paramTestCase.getRuleSetName().length() > 0)
    {
      DBModel localDBModel;
      Object localObject7;
      try
      {
        localObject2 = null;
        if (paramTestCase.getRuleSet() != null)
          localObject2 = RuleEngineFactory.getInstance(paramTestCase.getRuleSet().getUuid()).getRuleEngine();
        else
          localObject2 = RuleEngineFactory.newInstance().getRuleEngine();
        ((RuleEngine)localObject2).putAll(localHashMap1);
        for (int i = 0; i < localArrayList.size(); i++)
          ((RuleEngine)localObject2).put(localArrayList.get(i));
        ((RuleEngine)localObject2).excuteNew(paramTestCase.getRuleSetName());
        localHashMap1.clear();
        localHashMap1.putAll(((RuleEngine)localObject2).getAll());
        if (paramTestCase.getEnvionment() != null)
        {
          localObject4 = paramTestCase.getEnvionment().getAcceptElements(new P(this));
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (SheetTable)((Iterator)localObject4).next();
            ((SheetTable)localObject5).setSheetData((Sheet)localHashMap1.get(((SheetTable)localObject5).getValueName()));
          }
          localObject4 = paramTestCase.getEnvionment().getExcelBookModels();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (ExcelBookModel)((Iterator)localObject4).next();
            ((ExcelBookModel)localObject5).setExcelData((IExcelBook)localHashMap1.get(((ExcelBookModel)localObject5).getValueName()));
          }
        }
        System.gc();
      }
      catch (RuleEngineException localRuleEngineException)
      {
        a(u.a("runRule.error", "运行指定规则包时出错") + paramTestCase.getRuleSetName(), paramTestCase, localRuleEngineException.getMessage());
        return;
      }
      catch (Exception localException1)
      {
        a(u.a("runRule.error", "运行指定规则包时出错") + paramTestCase.getRuleSetName(), paramTestCase, localException1.getMessage());
        return;
      }
      finally
      {
        for (j = 0; j < ((ArrayList)localObject1).size(); j++)
        {
          localDBModel = (DBModel)((ArrayList)localObject1).get(j);
          localObject7 = localHashMap1.get(localDBModel.getValueName());
          if (localObject7 != null)
            try
            {
              if (((localObject7 instanceof Connection)) && (!((Connection)localObject7).isClosed()))
                ((Connection)localObject7).close();
              else if ((localObject7 instanceof DBConnection))
                ((DBConnection)localObject7).forceCloseConnection();
            }
            catch (Exception localException8)
            {
              localException8.printStackTrace();
            }
          localHashMap1.remove(localDBModel.getValueName());
        }
      }
      for (int j = 0; j < ((ArrayList)localObject1).size(); j++)
      {
        localDBModel = (DBModel)((ArrayList)localObject1).get(j);
        localObject7 = localHashMap1.get(localDBModel.getValueName());
        if (localObject7 != null)
          try
          {
            if (((localObject7 instanceof Connection)) && (!((Connection)localObject7).isClosed()))
              ((Connection)localObject7).close();
            else if ((localObject7 instanceof DBConnection))
              ((DBConnection)localObject7).forceCloseConnection();
          }
          catch (Exception localException9)
          {
            localException9.printStackTrace();
          }
        localHashMap1.remove(localDBModel.getValueName());
      }
    }
    localIterator = paramTestCase.getChildrenIterator();
    while (localIterator.hasNext())
    {
      TestObjectInfo localTestObjectInfo = (TestObjectInfo)localIterator.next();
      if (localTestObjectInfo.getClassName().length() > 0)
      {
        localObject4 = a(localArrayList, localTestObjectInfo.getClassName());
        try
        {
          localObject5 = com.flagleader.repository.d.r.b(localObject4, localTestObjectInfo.getAttributeName());
          localTestObjectInfo.setResultValue(localObject5);
          if ((!localTestObjectInfo.isOutVariable()) || (localTestObjectInfo.isEqualValue(localObject5.toString())))
            continue;
          a(u.a("expectValue.error", new Object[] { localTestObjectInfo.getDisplayName(), localTestObjectInfo.getExpectValue(), localObject5 }), paramTestCase, localTestObjectInfo.toString());
        }
        catch (Exception localException5)
        {
          a(u.a("expectValue.error", new Object[] { localTestObjectInfo.getDisplayName(), localTestObjectInfo.getExpectValue() }), paramTestCase, localTestObjectInfo.toString());
        }
      }
      else
      {
        localObject4 = localHashMap1.get(localTestObjectInfo.getAttributeName());
        if (localTestObjectInfo.getAttributeName().equalsIgnoreCase("ruleLog"))
        {
          localTestObjectInfo.setResultValue(localRuleLogList);
        }
        else
        {
          localTestObjectInfo.setResultValue(localObject4);
          if (!localTestObjectInfo.isOutVariable())
            continue;
          if (localObject4 == null)
          {
            if (StringUtil.isEmpty(localTestObjectInfo.getExpectValue()))
              continue;
            a(u.a("expectValue.error", new Object[] { localTestObjectInfo.getDisplayName(), localTestObjectInfo.getExpectValue(), localObject4 }), paramTestCase, localTestObjectInfo.toString());
          }
          else
          {
            if (LangUtil.equals(localObject4, paramTestCase.getTypeManager().a(localTestObjectInfo.getType()).f(localTestObjectInfo.getExpectValue())))
              continue;
            a(u.a("expectValue.error", new Object[] { localTestObjectInfo.getDisplayName(), localTestObjectInfo.getExpectValue(), localObject4 }), paramTestCase, localTestObjectInfo.toString());
          }
        }
      }
    }
  }

  public Object a(List paramList, String paramString)
  {
    int i = 0;
    while ((paramList != null) && (i < paramList.size()))
      try
      {
        if (paramList.get(i).getClass().getName().equals(paramString))
          return paramList.get(i);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i++;
      }
    return null;
  }

  private Class a(TestCase paramTestCase, String paramString)
  {
    if (paramTestCase.getRuleSet() != null)
      return RuleEngineFactory.getInstance(paramTestCase.getRuleSet().getUuid()).getClassLoader().loadClass(paramString);
    return RuleEngineFactory.newInstance().getClassLoader().loadClass(paramString);
  }

  public String a()
  {
    return c.b("TestCaseTread.info");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.N
 * JD-Core Version:    0.6.0
 */