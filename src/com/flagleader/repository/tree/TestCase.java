package com.flagleader.repository.tree;

import com.flagleader.a.A;
import com.flagleader.a.B;
import com.flagleader.a.ak;
import com.flagleader.a.y;
import com.flagleader.a.z;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rom.BusinessObjectAttribute;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.rom.BusinessObjectMember;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;

public class TestCase extends AbstractPackageElement
{
  public static final String NAME = "TestCase";
  public static final String DISPLAYNAME = getLocalString("TestCase.text");
  public static final NodeInfo nodeInfo = new NodeInfo("TestCase", DISPLAYNAME, DISPLAYNAME);
  private transient Map checkRuleMap;

  public TestCase(TestCase paramTestCase)
  {
    super(paramTestCase);
  }

  public TestCase(String paramString)
  {
    super(paramString);
  }

  public TestCase()
  {
  }

  public String getName()
  {
    return "TestCase";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitTestCase(this);
  }

  public IElement deepClone()
  {
    return new TestCase(this);
  }

  public String getRuleSetName()
  {
    return getTestLib().getRuleSetName();
  }

  public ao getTestLib()
  {
    if ((getParent() != null) && ((getParent() instanceof ao)))
      return (ao)getParent();
    return null;
  }

  public IRulePackage getRuleSet()
  {
    return getTestLib().getMainPackage();
  }

  public Envionment getEnvionment()
  {
    if (getTestLib() != null)
      return getTestLib().getEnvionment();
    return super.getEnvionment();
  }

  public void initVariables()
  {
    clearAllChildren();
    if ((getRuleSet() instanceof RulePackage))
    {
      RulePackage localRulePackage = (RulePackage)getRuleSet();
      Iterator localIterator = localRulePackage.getEnvionment().getValueLibrary().getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof MappingVariable))
          continue;
        MappingVariable localMappingVariable = (MappingVariable)localObject;
        addChildElement(new TestObjectInfo("", localMappingVariable.getValueName(), localMappingVariable.getDisplayName(), localMappingVariable.getValueType()));
      }
    }
  }

  public void init()
  {
    clearAllChildren();
    if ((getRuleSet() instanceof RulePackage))
    {
      RulePackage localRulePackage = (RulePackage)getRuleSet();
      Iterator localIterator = localRulePackage.getEnvionment().getAllTestVariable();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        Object localObject2;
        if ((localObject1 instanceof BusinessObjectAttribute))
        {
          localObject2 = (BusinessObjectAttribute)localObject1;
          addChildElement(new TestObjectInfo(((BusinessObjectAttribute)localObject2).getMemberClassName(), ((BusinessObjectAttribute)localObject2).getMemberName(), ((BusinessObjectAttribute)localObject2).getDisplayName(), ((BusinessObjectAttribute)localObject2).getValueType()));
        }
        else if ((localObject1 instanceof MappingVariable))
        {
          localObject2 = (MappingVariable)localObject1;
          addChildElement(new TestObjectInfo("", ((MappingVariable)localObject2).getValueName(), ((MappingVariable)localObject2).getDisplayName(), ((MappingVariable)localObject2).getValueType()));
        }
        else if (((localObject1 instanceof BusinessObjectClass)) && (!(localObject1 instanceof FunctionClass)))
        {
          localObject2 = ((BusinessObjectClass)localObject1).getClazz();
          z localz = ((B)localObject2).m().a();
          String str1 = ((B)localObject2).K();
          while (localz.hasNext())
          {
            y localy = (y)localz.next();
            int i = a((B)localObject2, localy);
            if (i <= 0)
              continue;
            String str2 = localy.N();
            String str3 = localy.e().K();
            if (i == 1)
              addChildElement(new TestObjectInfo(str1, str2, ((BusinessObjectClass)localObject1).getMemberToken(localy.I()).getDisplayName(), str3));
            else
              addChildElement(new TestObjectInfo(str1, str2, localy.I(), str3));
          }
        }
        else if ((localObject1 instanceof XmlNode))
        {
          localObject2 = (XmlNode)localObject1;
          addChildElement(new TestObjectInfo("", ((XmlNode)localObject2).getValueName(), ((XmlNode)localObject2).getDisplayName(), ((XmlNode)localObject2).getValueType()));
        }
        else
        {
          if (!(localObject1 instanceof TreeValueNode))
            continue;
          localObject2 = (TreeValueNode)localObject1;
          addChildElement(new TestObjectInfo("", ((TreeValueNode)localObject2).getValueName(), ((TreeValueNode)localObject2).getDisplayName(), ((TreeValueNode)localObject2).getValueType()));
        }
      }
      addChildElement(new TestObjectInfo("", "ruleLog", "Log", "com.flagleader.rules.RuleLog"));
    }
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

  public void updateInfo()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(a());
    init();
    for (int i = 0; i < localArrayList.size(); i++)
    {
      TestObjectInfo localTestObjectInfo1 = (TestObjectInfo)localArrayList.get(i);
      TestObjectInfo localTestObjectInfo2 = a(localTestObjectInfo1);
      if (localTestObjectInfo2 == null)
        continue;
      localTestObjectInfo2.setInitialValue(localTestObjectInfo1.getInitialValue());
      localTestObjectInfo2.setExpectValue(localTestObjectInfo1.getExpectValue());
      localTestObjectInfo2.setResultValue(localTestObjectInfo1.getResultValue());
    }
    if (a(localArrayList))
      setModified(true);
  }

  private boolean a(List paramList)
  {
    List localList = a();
    if (paramList.size() != localList.size())
      return true;
    for (int i = 0; i < paramList.size(); i++)
    {
      TestObjectInfo localTestObjectInfo1 = (TestObjectInfo)paramList.get(i);
      TestObjectInfo localTestObjectInfo2 = (TestObjectInfo)localList.get(i);
      if ((!localTestObjectInfo1.getInitialValue().equals(localTestObjectInfo2.getInitialValue())) || (!localTestObjectInfo1.getExpectValue().equals(localTestObjectInfo2.getExpectValue())))
        return true;
    }
    return false;
  }

  private TestObjectInfo a(TestObjectInfo paramTestObjectInfo)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      TestObjectInfo localTestObjectInfo = (TestObjectInfo)localList.get(i);
      if ((localTestObjectInfo.getClassName().equals(paramTestObjectInfo.getClassName())) && (localTestObjectInfo.getAttributeName().equals(paramTestObjectInfo.getAttributeName())))
        return localTestObjectInfo;
    }
    return null;
  }

  public TestObjectInfo getMatchTestObjectInfo(String paramString)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      TestObjectInfo localTestObjectInfo = (TestObjectInfo)localList.get(i);
      if (localTestObjectInfo.getDisplayName().equals(paramString))
        return localTestObjectInfo;
    }
    return null;
  }

  public boolean isLocked()
  {
    if (getParent() != null)
      return getParent().isLocked();
    return super.isLocked();
  }

  public Map getCheckRuleMap()
  {
    if (this.checkRuleMap == null)
      this.checkRuleMap = new HashMap();
    return this.checkRuleMap;
  }

  public void setCheckRuleMap(Map paramMap)
  {
    this.checkRuleMap = paramMap;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.TestCase
 * JD-Core Version:    0.6.0
 */