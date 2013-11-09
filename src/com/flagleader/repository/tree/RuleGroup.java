package com.flagleader.repository.tree;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.util.exception.UnsupportOperationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleGroup extends AbstractTreeNode
  implements IRuleGroup
{
  public static final String NAME = "RuleGroup";
  public static final String DISPLAYNAME = getLocalString("RuleGroup.text");
  public static final NodeInfo nodeInfo = new NodeInfo("RuleGroup", DISPLAYNAME, DISPLAYNAME);

  public RuleGroup()
  {
  }

  public RuleGroup(String paramString)
  {
    setDisplayName(paramString);
  }

  public RuleGroup(RuleGroup paramRuleGroup)
  {
    super(paramRuleGroup);
  }

  public Envionment getEnvionment()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof Envionment))
        return (Envionment)localObject;
    }
    if (getProject() != null)
      return getProject().getEnvionment();
    return null;
  }

  public Iterator getRulePackages()
  {
    return getAcceptElements(new ar(this));
  }

  public void updateTableDisplayNames()
  {
    Iterator localIterator = getRulePackages();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RulePackage))
        continue;
      ((RulePackage)localObject).getEnvionment().updateTableDisplayNames();
    }
  }

  public int getRuleGroupCount()
  {
    int i = 0;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RuleGroup))
        continue;
      i++;
    }
    return i;
  }

  public int getRulePackageCount()
  {
    int i = 0;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RulePackage))
        continue;
      i++;
    }
    return i;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    throw new UnsupportOperationException();
  }

  public String getName()
  {
    return "RuleGroup";
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof RulePackage)) || ((paramIElement instanceof Envionment)) || ((paramIElement instanceof RuleGroup)) || ((paramIElement instanceof TestCaseLib));
  }

  public IElement deepClone()
  {
    return new RuleGroup(this);
  }

  public void addChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof RuleGroup))
      super.addChildElement(paramIElement, getRuleGroupCount());
    else if ((paramIElement instanceof RulePackage))
      super.addChildElement(paramIElement, getRuleGroupCount() + getRulePackageCount());
    else if ((paramIElement instanceof TestCaseLib))
      super.addChildElement(paramIElement, getChildrenCount());
    else
      super.addChildElement(paramIElement);
  }

  protected boolean b()
  {
    return super.b();
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    return ((paramITreeNode instanceof RulePackage)) || ((paramITreeNode instanceof RuleGroup)) || ((paramITreeNode instanceof TestCaseLib));
  }

  public boolean acceptNode(String paramString)
  {
    if (b())
      return false;
    return (paramString.equals("RulePackage")) || (paramString.equals("RuleGroup")) || (paramString.equals("TestCaseLib"));
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean canUpdate()
  {
    return true;
  }

  public ITreeNode createChildNode(String paramString)
  {
    Object localObject;
    if (paramString.equalsIgnoreCase("RulePackage"))
    {
      localObject = new RulePackage(getChildDefaultName(RulePackage.DISPLAYNAME));
      if (getProject() != null)
        addChildElement((IElement)localObject);
      ((RulePackage)localObject).setDirPath(getProject().getDataDir());
      ((RulePackage)localObject).setPackageName(getShowDisplayName());
      if (getEnvionment() != null)
        ((RulePackage)localObject).addChildElement(getEnvionment().deepClone());
      else
        ((RulePackage)localObject).addChildElement(Envionment.getEmptyEnvionment());
      ((RulePackage)localObject).getEnvionment().setDisplayName(Envionment.DISPLAYNAME);
      if (getProject() != null)
        getProject().setModified(true);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("RuleGroup"))
    {
      localObject = new RuleGroup(getChildDefaultName(DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (getProject() != null)
        getProject().setModified(true);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("TestCaseLib"))
    {
      localObject = new TestCaseLib(getChildDefaultName(TestCaseLib.DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (getProject() != null)
        getProject().setModified(true);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("Envionment"))
    {
      localObject = Envionment.getEmptyEnvionment();
      ((Envionment)localObject).setDisplayName(getChildDefaultName(((Envionment)localObject).getDisplayName()));
      addChildElement((IElement)localObject);
      if (getProject() != null)
        getProject().setModified(true);
      return localObject;
    }
    return (ITreeNode)super.createChildNode(paramString);
  }

  public Iterator getAcceptNodes()
  {
    if (b())
      return super.getAcceptNodes();
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(RulePackage.nodeInfo);
    localArrayList.add(nodeInfo);
    localArrayList.add(TestCaseLib.nodeInfo);
    return localArrayList.iterator();
  }

  public RulePackage exitsPackage(String paramString)
  {
    if (getProject() != null)
      return getProject().exitsPackage(paramString);
    return null;
  }

  public boolean changePackageGroupName()
  {
    int i = 0;
    List localList = a();
    for (int j = 0; j < localList.size(); j++)
    {
      Object localObject = localList.get(j);
      if ((localObject instanceof RuleGroup))
      {
        boolean bool = ((RuleGroup)localObject).changePackageGroupName();
        if (!bool)
          continue;
        i = bool;
      }
      else
      {
        if ((!(localObject instanceof RulePackage)) || (((RulePackage)localObject).getPackageName().equalsIgnoreCase(getShowDisplayName())))
          continue;
        ((RulePackage)localObject).setPackageName(getShowDisplayName());
        ((RulePackage)localObject).setModified(true);
        i = 1;
      }
    }
    return i;
  }

  public boolean paste(IElement paramIElement)
  {
    if (((paramIElement instanceof ITreeNode)) && (acceptNode((ITreeNode)paramIElement)))
    {
      super.paste(paramIElement);
      if (((paramIElement instanceof RulePackage)) && (getProject() != null))
      {
        ((RulePackage)paramIElement).setDirPath(getProject().getDataDir());
        ((RulePackage)paramIElement).setPackageName(getShowDisplayName());
      }
      setModified(true);
      updateTree();
      return true;
    }
    if ((paramIElement instanceof ElementContainer))
    {
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        super.paste((IElement)localObject);
        if ((!(localObject instanceof RulePackage)) || (getProject() == null))
          continue;
        ((RulePackage)localObject).setDirPath(getProject().getDataDir());
      }
      setModified(true);
      updateTree();
      return true;
    }
    return false;
  }

  protected boolean a(String paramString, Class paramClass)
  {
    Iterator localIterator = getProject().getAcceptElements(new as(this));
    while (localIterator.hasNext())
    {
      ITreeNode localITreeNode = (ITreeNode)localIterator.next();
      if ((localITreeNode.getClass().equals(paramClass)) && (localITreeNode.getDisplayName().equals(paramString)))
        return true;
    }
    return false;
  }

  public void save()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof RulePackage))
      {
        ((RulePackage)localObject).save();
        ((RulePackage)localObject).setModified(false);
      }
      else if ((localObject instanceof Envionment))
      {
        ((Envionment)localObject).save();
      }
      else
      {
        if (!(localObject instanceof TestCaseLib))
          continue;
        ((TestCaseLib)localObject).save();
      }
    }
    if (getProject() != null)
      getProject().selfSave();
    setModified(false);
  }

  public boolean isModified()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof ITreeNode)) && (((ITreeNode)localObject).isModified()))
        return true;
    }
    return false;
  }

  public boolean isNeedSave()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof ITreeNode)) && (((ITreeNode)localObject).isNeedSave()))
        return true;
    }
    return false;
  }

  public void setModified(boolean paramBoolean)
  {
    if ((paramBoolean) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(paramBoolean);
  }

  public void dispose()
  {
    super.dispose();
  }

  public void disposeAndUpdate()
  {
    IElement localIElement = null;
    if (getParent() != null)
      localIElement = getParent();
    super.dispose();
    if (localIElement != null)
    {
      if ((localIElement instanceof RuleProject))
        ((RuleProject)localIElement).setModified(true);
      else if (getProject() != null)
        getProject().setModified(true);
      if ((localIElement instanceof ITreeNode))
        ((ITreeNode)localIElement).updateTree();
    }
  }

  public boolean isVisible()
  {
    return true;
  }

  public IRuleRepository getRepository()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleProject)))
      return ((IRuleProject)getParent()).getRepository();
    if ((getParent() != null) && ((getParent() instanceof RuleGroup)))
      return ((RuleGroup)getParent()).getRepository();
    return null;
  }

  public String toString()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleGroup)))
      return getParent().toString() + "-" + getDisplayName();
    return getDisplayName();
  }

  public RuleGroup getSubGroup(String[] paramArrayOfString, int paramInt)
  {
    if (paramInt < paramArrayOfString.length)
      return createGroup(paramArrayOfString[paramInt]).getSubGroup(paramArrayOfString, paramInt + 1);
    return this;
  }

  public RuleGroup createGroup(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((localObject instanceof RuleGroup)) && (((RuleGroup)localObject).getDisplayName().equalsIgnoreCase(paramString)))
        return (RuleGroup)localObject;
    }
    Object localObject = new RuleGroup(paramString);
    addChildElement((IElement)localObject);
    return (RuleGroup)localObject;
  }

  public String getShowDisplayName()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleGroup)))
      return getParent().getShowDisplayName() + "." + getDisplayName();
    return getDisplayName();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.RuleGroup
 * JD-Core Version:    0.6.0
 */