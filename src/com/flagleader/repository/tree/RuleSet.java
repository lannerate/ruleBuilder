package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.rlm.RuleSetToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RuleSet extends AbstractRuleSet
  implements IElement, IDebugNode, IRuleSet, IRuleTree, am
{
  public static final String NAME = "RuleSet";
  public static final String DISPLAYNAME = getLocalString("RuleSet.text");
  public static final String COMMNAME = getLocalString("RuleSet.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("RuleSet", DISPLAYNAME, DISPLAYNAME);
  private boolean editTable = false;

  public RuleSet()
  {
    setEditType(3);
  }

  public RuleSet(RuleSet paramRuleSet)
  {
    super(paramRuleSet);
    this.editTable = paramRuleSet.editTable;
  }

  public RuleSet(String paramString)
  {
    super(paramString);
    setEditType(3);
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    return (paramITreeNode instanceof IRuleTree);
  }

  public boolean acceptNode(String paramString)
  {
    if (b())
      return false;
    return (paramString.equals("RuleSet")) || (paramString.equals("RuleSetFlow")) || (paramString.equals("RuleTreeFlow")) || (paramString.equals("Rule")) || (paramString.equals("RuleMirror")) || (paramString.equals("RulePoolFlow")) || (paramString.equals("DecisionRule")) || (paramString.equals("DecisionMultiRule")) || (paramString.equals("DecisionRelateRule")) || (paramString.equals("ExpressionRule"));
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRuleSet(this);
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof IRuleTree)) || ((paramIElement instanceof RuleSetToken)) || ((paramIElement instanceof CheckRuleInfo));
  }

  public ITreeNode createChildNode(String paramString)
  {
    Object localObject;
    if (paramString.equalsIgnoreCase("RuleSet"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new RuleSet(getChildDefaultName(DISPLAYNAME));
      addChildElement((am)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("RuleSetFlow"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new RuleSetFlow(getChildDefaultName(RuleSetFlow.DISPLAYNAME));
      addChildElement((am)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("RuleTreeFlow"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new RuleTreeFlow(getChildDefaultName(RuleTreeFlow.DISPLAYNAME));
      addChildElement((am)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("RulePoolFlow"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new RulePoolFlow(getChildDefaultName(RulePoolFlow.DISPLAYNAME));
      addChildElement((am)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("Rule"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new Rule(getChildDefaultName(Rule.DISPLAYNAME));
      addChildElement((am)localObject);
      updateTree();
      return localObject;
    }
    if (paramString.equalsIgnoreCase("DecisionRule"))
    {
      localObject = new DecisionRule(getChildDefaultName(DecisionRule.DISPLAYNAME));
      addChildElement((am)localObject);
      updateTree();
      return localObject;
    }
    if (paramString.equalsIgnoreCase("DecisionMultiRule"))
    {
      localObject = new DecisionMultiRule(getChildDefaultName(DecisionMultiRule.DISPLAYNAME));
      addChildElement((am)localObject);
      updateTree();
      return localObject;
    }
    if (paramString.equalsIgnoreCase("ExpressionRule"))
    {
      localObject = new ExpressionRule(getChildDefaultName(ExpressionRule.DISPLAYNAME));
      addChildElement((am)localObject);
      updateTree();
      return localObject;
    }
    if (paramString.equalsIgnoreCase("DecisionRelateRule"))
    {
      localObject = new DecisionRelateRule(getChildDefaultName(DecisionRelateRule.DISPLAYNAME));
      addChildElement((am)localObject);
      updateTree();
      return localObject;
    }
    return (ITreeNode)super.createChildNode(paramString);
  }

  public IElement deepClone()
  {
    return new RuleSet(this);
  }

  public Iterator getAcceptNodes()
  {
    if (b())
      return super.getAcceptNodes();
    ArrayList localArrayList = new ArrayList(6);
    localArrayList.add(nodeInfo);
    localArrayList.add(RuleSetFlow.nodeInfo);
    localArrayList.add(RuleTreeFlow.nodeInfo);
    localArrayList.add(RulePoolFlow.nodeInfo);
    localArrayList.add(Rule.nodeInfo);
    localArrayList.add(DecisionRule.nodeInfo);
    localArrayList.add(DecisionMultiRule.nodeInfo);
    localArrayList.add(ExpressionRule.nodeInfo);
    localArrayList.add(DecisionRelateRule.nodeInfo);
    return localArrayList.iterator();
  }

  public String getName()
  {
    return "RuleSet";
  }

  public boolean isChangedshint()
  {
    if ((getMainPackage() != null) && (getMainPackage().canFindHistory()))
    {
      IPackageElement localIPackageElement = getMainPackage().findRuleHistory(getUuid(), toString());
      if ((localIPackageElement == null) || (!(localIPackageElement instanceof RuleSet)) || (!getRuleSetToken().getText().equals(((RuleSet)localIPackageElement).getRuleSetToken().getText())))
        return true;
    }
    return this.e;
  }

  public boolean isEditTable()
  {
    return this.editTable;
  }

  public void setEditTable(boolean paramBoolean)
  {
    this.editTable = paramBoolean;
  }

  public boolean replaceVariable(Map paramMap)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IRuleTree))
        continue;
      ((IRuleTree)localObject).replaceVariable(paramMap);
    }
    if (super.a(paramMap, getRuleSetToken()))
    {
      setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.RuleSet
 * JD-Core Version:    0.6.0
 */