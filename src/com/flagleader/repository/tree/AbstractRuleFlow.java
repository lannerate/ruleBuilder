package com.flagleader.repository.tree;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.rlm.RuleSetToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractRuleFlow extends AbstractRuleSet
  implements IRuleFlow, IRuleSet
{
  public AbstractRuleFlow()
  {
  }

  public AbstractRuleFlow(AbstractRuleFlow paramAbstractRuleFlow)
  {
    super(paramAbstractRuleFlow);
  }

  public AbstractRuleFlow(String paramString)
  {
    super(paramString);
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    return ((paramITreeNode instanceof RuleSet)) || ((paramITreeNode instanceof IRule)) || ((paramITreeNode instanceof RuleFlowActivitie)) || ((paramITreeNode instanceof RuleFlowTransition));
  }

  public boolean acceptNode(String paramString)
  {
    if (b())
      return false;
    return (paramString.equals("RuleSet")) || (paramString.equals("Rule")) || (paramString.equals("DecisionRule")) || (paramString.equals("DecisionMultiRule")) || (paramString.equals("DecisionRelateRule")) || (paramString.equals("RuleMirror")) || (paramString.equals("ExpressionRule")) || (paramString.equals("RuleTreeFlow")) || (paramString.equals("RulePoolFlow"));
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof IRuleTree)) || ((paramIElement instanceof RuleFlowActivitie)) || ((paramIElement instanceof RuleFlowTransition)) || ((paramIElement instanceof RuleSetToken));
  }

  public ITreeNode createChildNode(String paramString)
  {
    return createChildNode(paramString, true);
  }

  public ITreeNode createChildNode(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (paramString.equalsIgnoreCase("RuleSet"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new RuleSet(getChildDefaultName(RuleSet.DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (paramBoolean)
      {
        addFlowActivitie(((RuleSet)localObject).getUuid(), "RULESET");
        updateViewer();
      }
      return localObject;
    }
    if (paramString.equalsIgnoreCase("Rule"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new Rule(getChildDefaultName(Rule.DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (paramBoolean)
      {
        addFlowActivitie(((Rule)localObject).getUuid(), "RULE");
        updateViewer();
      }
      updateTree();
      return localObject;
    }
    if (paramString.equalsIgnoreCase("DecisionRule"))
    {
      localObject = new DecisionRule(getChildDefaultName(DecisionRule.DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (paramBoolean)
      {
        addFlowActivitie(((DecisionRule)localObject).getUuid(), "DECISIONRULE");
        updateViewer();
      }
      updateTree();
      return localObject;
    }
    if (paramString.equalsIgnoreCase("DecisionMultiRule"))
    {
      localObject = new DecisionMultiRule(getChildDefaultName(DecisionMultiRule.DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (paramBoolean)
      {
        addFlowActivitie(((DecisionMultiRule)localObject).getUuid(), "DECISIONMULTIRULE");
        updateViewer();
      }
      updateTree();
      return localObject;
    }
    if (paramString.equalsIgnoreCase("ExpressionRule"))
    {
      localObject = new ExpressionRule(getChildDefaultName(ExpressionRule.DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (paramBoolean)
      {
        addFlowActivitie(((ExpressionRule)localObject).getUuid(), "EXPRESSIONRULE");
        updateViewer();
      }
      updateTree();
      return localObject;
    }
    if (paramString.equalsIgnoreCase("DecisionRelateRule"))
    {
      localObject = new DecisionRelateRule(getChildDefaultName(DecisionRelateRule.DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (paramBoolean)
      {
        addFlowActivitie(((DecisionRelateRule)localObject).getUuid(), "DECISIONRELATERULE");
        updateViewer();
      }
      updateTree();
      return localObject;
    }
    if (paramString.equalsIgnoreCase("RuleTreeFlow"))
    {
      localObject = new RuleTreeFlow(getChildDefaultName(RuleTreeFlow.DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (paramBoolean)
      {
        addFlowActivitie(((RuleTreeFlow)localObject).getUuid(), "RULETREEFLOW");
        updateViewer();
      }
      updateTree();
      return localObject;
    }
    if (paramString.equalsIgnoreCase("RuleSetFlow"))
    {
      localObject = new RuleSetFlow(getChildDefaultName(RuleSetFlow.DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (paramBoolean)
      {
        addFlowActivitie(((RuleSetFlow)localObject).getUuid(), "RULESETFLOW");
        updateViewer();
      }
      updateTree();
      return localObject;
    }
    if (paramString.equalsIgnoreCase("RulePoolFlow"))
    {
      localObject = new RulePoolFlow(getChildDefaultName(RulePoolFlow.DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (paramBoolean)
      {
        addFlowActivitie(((RulePoolFlow)localObject).getUuid(), "RULEPOOLFLOW");
        updateViewer();
      }
      updateTree();
      return localObject;
    }
    return (ITreeNode)super.createChildNode(paramString);
  }

  public Iterator getAcceptNodes()
  {
    if (b())
      return super.getAcceptNodes();
    ArrayList localArrayList = new ArrayList(6);
    localArrayList.add(RuleSet.nodeInfo);
    localArrayList.add(Rule.nodeInfo);
    localArrayList.add(DecisionRule.nodeInfo);
    localArrayList.add(DecisionMultiRule.nodeInfo);
    localArrayList.add(ExpressionRule.nodeInfo);
    localArrayList.add(DecisionRelateRule.nodeInfo);
    return localArrayList.iterator();
  }

  public RuleFlowActivitie addNode(String paramString, int paramInt1, int paramInt2)
  {
    ITreeNode localITreeNode = null;
    if (paramString.equalsIgnoreCase("RULE"))
      localITreeNode = createChildNode("Rule", false);
    else if (paramString.equalsIgnoreCase("RULESET"))
      localITreeNode = createChildNode("RuleSet", false);
    else if (paramString.equalsIgnoreCase("DECISIONRULE"))
      localITreeNode = createChildNode("DecisionRule", false);
    else if (paramString.equalsIgnoreCase("DECISIONMULTIRULE"))
      localITreeNode = createChildNode("DecisionMultiRule", false);
    else if (paramString.equalsIgnoreCase("EXPRESSIONRULE"))
      localITreeNode = createChildNode("ExpressionRule", false);
    else if (paramString.equalsIgnoreCase("DECISIONRELATERULE"))
      localITreeNode = createChildNode("DecisionRelateRule", false);
    updateTree();
    if (localITreeNode != null)
      return addFlowActivitie(localITreeNode.getUuid(), paramString, paramInt1, paramInt2);
    return addFlowActivitie("", paramString, paramInt1, paramInt2);
  }

  public boolean exitsTransition(String paramString1, String paramString2)
  {
    List localList = a();
    int i = 0;
    for (int j = localList.size() - 1; j >= 0; j--)
    {
      if (!(localList.get(j) instanceof RuleFlowTransition))
        continue;
      RuleFlowTransition localRuleFlowTransition = (RuleFlowTransition)localList.get(j);
      if ((localRuleFlowTransition.getFromUuid().equalsIgnoreCase(paramString1)) && (localRuleFlowTransition.getToUuid().equalsIgnoreCase(paramString2)))
        return true;
    }
    return false;
  }

  public IElement addTrans(String paramString1, String paramString2)
  {
    if ((getFlowElement(paramString1) != null) && (getFlowElement(paramString2) != null))
    {
      RuleFlowTransition localRuleFlowTransition = new RuleFlowTransition(paramString1, paramString2);
      addChildElement(localRuleFlowTransition);
      return localRuleFlowTransition;
    }
    return null;
  }

  public IRuleTree getRuleObject(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof IRuleTree)) && (((IRuleTree)localObject).getUuid().equalsIgnoreCase(paramString)))
        return (IRuleTree)localObject;
    }
    return null;
  }

  public boolean removeNode(String paramString)
  {
    if (getRuleObject(paramString) != null)
    {
      getRuleObject(paramString).disposeAndUpdate();
      updateTree();
      return true;
    }
    return removeFlowElements(paramString);
  }

  public RuleFlowActivitie addFlowActivitie(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    RuleFlowActivitie localRuleFlowActivitie = new RuleFlowActivitie(paramString1, paramInt1, paramInt2, paramString2);
    addChildElement(localRuleFlowActivitie);
    return localRuleFlowActivitie;
  }

  public RuleFlowActivitie addFlowActivitie(String paramString1, String paramString2)
  {
    RuleFlowActivitie localRuleFlowActivitie = new RuleFlowActivitie(paramString1, 200, getMaxY(200) + 50, paramString2);
    addChildElement(localRuleFlowActivitie);
    return localRuleFlowActivitie;
  }

  public int getMaxY(int paramInt)
  {
    List localList = a();
    int i = 0;
    for (int j = localList.size() - 1; j >= 0; j--)
    {
      if ((!(localList.get(j) instanceof RuleFlowActivitie)) || (((RuleFlowActivitie)localList.get(j)).getX() < paramInt) || (paramInt > ((RuleFlowActivitie)localList.get(j)).getX() + ((RuleFlowActivitie)localList.get(j)).getWidth()) || (((RuleFlowActivitie)localList.get(j)).getY() <= i))
        continue;
      i = ((RuleFlowActivitie)localList.get(j)).getY();
    }
    return i;
  }

  public List getNextTransitions(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      if (!(localList.get(i) instanceof RuleFlowTransition))
        continue;
      RuleFlowTransition localRuleFlowTransition = (RuleFlowTransition)localList.get(i);
      if (!localRuleFlowTransition.getFromUuid().equals(paramString))
        continue;
      a(localRuleFlowTransition, localArrayList);
    }
    return localArrayList;
  }

  protected RuleFlowActivitie a(String paramString)
  {
    List localList = a();
    RuleFlowActivitie localRuleFlowActivitie;
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      if (!(localList.get(i) instanceof RuleFlowActivitie))
        continue;
      localRuleFlowActivitie = (RuleFlowActivitie)localList.get(i);
      if (localRuleFlowActivitie.getFlowUuid().equalsIgnoreCase(paramString))
        return localRuleFlowActivitie;
    }
    for (i = localList.size() - 1; i >= 0; i--)
    {
      if (!(localList.get(i) instanceof RuleFlowActivitie))
        continue;
      localRuleFlowActivitie = (RuleFlowActivitie)localList.get(i);
      if (localRuleFlowActivitie.getRuleUuid().equalsIgnoreCase(paramString))
        return localRuleFlowActivitie;
    }
    return null;
  }

  protected void a(RuleFlowTransition paramRuleFlowTransition, List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      RuleFlowTransition localRuleFlowTransition = (RuleFlowTransition)paramList.get(i);
      IRuleClass localIRuleClass1 = getRuleObject(a(localRuleFlowTransition.getToUuid()));
      IRuleClass localIRuleClass2 = getRuleObject(a(paramRuleFlowTransition.getToUuid()));
      if ((localIRuleClass1 == null) || (localIRuleClass2 == null) || (localIRuleClass1.getPos() <= localIRuleClass2.getPos()))
        continue;
      paramList.add(i, paramRuleFlowTransition);
      return;
    }
    paramList.add(paramRuleFlowTransition);
  }

  public boolean removeTrans(String paramString)
  {
    List localList = a();
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      if (!(localList.get(i) instanceof RuleFlowTransition))
        continue;
      RuleFlowTransition localRuleFlowTransition = (RuleFlowTransition)localList.get(i);
      if (!localRuleFlowTransition.getUuid().equalsIgnoreCase(paramString))
        continue;
      localRuleFlowTransition.dispose();
      return true;
    }
    return false;
  }

  public boolean paste(IElement paramIElement)
  {
    if ((paramIElement instanceof ElementContainer))
    {
      initUndoable();
      int i = 0;
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((!(localObject instanceof ITreeNode)) || (!acceptNode((ITreeNode)localObject)))
          continue;
        super.paste((ITreeNode)localObject);
        if ((localObject instanceof RuleSet))
        {
          addFlowActivitie(((ITreeNode)localObject).getUuid(), "RULESET");
          updateViewer();
        }
        else if ((localObject instanceof Rule))
        {
          addFlowActivitie(((ITreeNode)localObject).getUuid(), "RULE");
          updateViewer();
        }
        else if ((localObject instanceof DecisionRule))
        {
          addFlowActivitie(((ITreeNode)localObject).getUuid(), "DECISIONRULE");
          updateViewer();
        }
        else if ((localObject instanceof DecisionMultiRule))
        {
          addFlowActivitie(((ITreeNode)localObject).getUuid(), "DECISIONMULTIRULE");
          updateViewer();
        }
        else if ((localObject instanceof ExpressionRule))
        {
          addFlowActivitie(((ITreeNode)localObject).getUuid(), "EXPRESSIONRULE");
          updateViewer();
        }
        else if ((localObject instanceof DecisionRelateRule))
        {
          addFlowActivitie(((ITreeNode)localObject).getUuid(), "DECISIONRELATERULE");
          updateViewer();
        }
        else if ((localObject instanceof RuleMirror))
        {
          addFlowActivitie(((ITreeNode)localObject).getUuid(), "RULEMIRROR");
          updateViewer();
        }
        i = 1;
      }
      if (i != 0)
      {
        takeSnapshot();
        setModified(true);
      }
      updateTree();
      return true;
    }
    if (((paramIElement instanceof ITreeNode)) && (acceptNode((ITreeNode)paramIElement)))
    {
      initUndoable();
      super.paste(paramIElement);
      if ((paramIElement instanceof RuleSet))
      {
        addFlowActivitie(((ITreeNode)paramIElement).getUuid(), "RULESET");
        updateViewer();
      }
      else if ((paramIElement instanceof Rule))
      {
        addFlowActivitie(((ITreeNode)paramIElement).getUuid(), "RULE");
        updateViewer();
      }
      else if ((paramIElement instanceof DecisionRule))
      {
        addFlowActivitie(((ITreeNode)paramIElement).getUuid(), "DECISIONRULE");
        updateViewer();
      }
      else if ((paramIElement instanceof DecisionMultiRule))
      {
        addFlowActivitie(((ITreeNode)paramIElement).getUuid(), "DECISIONMULTIRULE");
        updateViewer();
      }
      updateTree();
      takeSnapshot();
      setModified(true);
      return true;
    }
    return false;
  }

  public boolean isEmpty()
  {
    if (getRuleSetToken().getTestConditions().getConditions().hasNext())
      return false;
    if (getRuleSetToken().getInitActions().getActions().hasNext())
      return false;
    if (getRuleSetToken().getBlockActions().getActions().hasNext())
      return false;
    if (getRuleSetToken().getFirstActions().getActions().hasNext())
      return false;
    if (getStartTransitions().size() > 0)
      return false;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof IRuleContainer)) && (!((IRuleContainer)localObject).isEmpty()))
        return false;
      if (((localObject instanceof IRuleTree)) && (!((IRuleTree)localObject).isEmpty()))
        return false;
    }
    return true;
  }

  public void removeChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof IRuleTree))
    {
      String str = paramIElement.getUuid();
      removeFlowElements(str);
    }
    super.removeChildElement(paramIElement);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.AbstractRuleFlow
 * JD-Core Version:    0.6.0
 */