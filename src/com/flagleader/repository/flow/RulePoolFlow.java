package com.flagleader.repository.flow;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.RuleSetToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.AbstractRuleSet;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.IDebugNode;
import com.flagleader.repository.tree.IRule;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.NodeInfo;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleFlowActivitie;
import com.flagleader.repository.tree.RuleMirror;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.RuleSetFlow;
import com.flagleader.repository.tree.RuleTreeFlow;
import com.flagleader.repository.tree.am;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class RulePoolFlow extends AbstractRuleSet
  implements IDebugNode, IRuleSet, IRuleTree, am
{
  public static final String NAME = "RulePoolFlow";
  public static final String DISPLAYNAME = getLocalString("RulePoolFlow.text");
  public static final String COMMNAME = getLocalString("RulePoolFlow.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("RulePoolFlow", DISPLAYNAME, DISPLAYNAME);
  private int poolType = 0;
  public static final int RULESPOOL = 0;

  public RulePoolFlow()
  {
  }

  public RulePoolFlow(RulePoolFlow paramRulePoolFlow)
  {
    super(paramRulePoolFlow);
  }

  public RulePoolFlow(String paramString)
  {
    super(paramString);
    setEditType(0);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRulePoolFlow(this);
  }

  public IElement deepClone()
  {
    return new RulePoolFlow(this);
  }

  public String getName()
  {
    return "RulePoolFlow";
  }

  public boolean removeFlowElements(String paramString)
  {
    List localList = a();
    int i = 0;
    for (int j = localList.size() - 1; j >= 0; j--)
    {
      if ((!(localList.get(j) instanceof RulePoolNode)) || ((!((RulePoolNode)localList.get(j)).getFlowUuid().equalsIgnoreCase(paramString)) && (!((RulePoolNode)localList.get(j)).getUuid().equalsIgnoreCase(paramString))))
        continue;
      ((RulePoolNode)localList.get(j)).dispose();
      i = 1;
    }
    return i;
  }

  public IRuleClass getRuleObject(RulePoolNode paramRulePoolNode)
  {
    Iterator localIterator = getRootParent().getAcceptElements(new a(this));
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((localObject instanceof IRuleClass)) && (((IRuleClass)localObject).getUuid().equalsIgnoreCase(paramRulePoolNode.getRuleUuid())))
        return (IRuleClass)localObject;
    }
    localIterator = getRootParent().getAcceptElements(new b(this));
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((localObject instanceof IRulePackage)) && (((IRulePackage)localObject).getExeRulePackageName().equalsIgnoreCase(paramRulePoolNode.getExeRuleName())))
        return (IRulePackage)localObject;
      if (!(localObject instanceof IRuleTree))
        continue;
      IRuleTree localIRuleTree = (IRuleTree)localObject;
      if (StringUtil.isEmpty(paramRulePoolNode.getExeRuleName()))
      {
        if ((localIRuleTree.getMainPackage().equals(getMainPackage())) && (localIRuleTree.getDisplayName().equals(paramRulePoolNode.getExeRuleDisplay())))
          return localIRuleTree;
      }
      else if (paramRulePoolNode.getExeRuleName().equals(localIRuleTree.getMainPackage().getExeRulePackageName() + localIRuleTree.getVisitRuleName()))
        return localIRuleTree;
    }
    return null;
  }

  public void addPoolValue(IBusinessObject paramIBusinessObject)
  {
    for (int i = 0; i < a().size(); i++)
    {
      Object localObject = a().get(i);
      if (((localObject instanceof RulePoolValue)) && (((RulePoolValue)localObject).getSelected().equals(paramIBusinessObject)))
        return;
    }
    RulePoolValue localRulePoolValue = new RulePoolValue("", paramIBusinessObject);
    addChildElement(localRulePoolValue);
  }

  public String getValuesDisplay()
  {
    List localList = getPoolValues();
    if (localList.size() > 0)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0; i < localList.size(); i++)
      {
        if (i > 0)
          localStringBuffer.append(",");
        RulePoolValue localRulePoolValue = (RulePoolValue)localList.get(i);
        localStringBuffer.append(localRulePoolValue.getDisplayName());
      }
      return localStringBuffer.toString();
    }
    return "";
  }

  public List getPoolValues()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RulePoolValue))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public List getPoolNodes()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof RulePoolNode)) || (((RulePoolNode)localObject).isStartNode()))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public RulePoolNode getStartTransitions()
  {
    List localList = a();
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      if (!(localList.get(i) instanceof RulePoolNode))
        continue;
      RulePoolNode localRulePoolNode = (RulePoolNode)localList.get(i);
      if (localRulePoolNode.isStartNode())
        return localRulePoolNode;
    }
    return addFlowActivitie("", "START_NODE", 100, 20);
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    return ((paramITreeNode instanceof RuleSet)) || ((paramITreeNode instanceof IRule)) || ((paramITreeNode instanceof RulePoolNode)) || ((paramITreeNode instanceof RulePoolValue));
  }

  public boolean acceptNode(String paramString)
  {
    if (b())
      return false;
    return (paramString.equals("RuleSet")) || (paramString.equals("Rule")) || (paramString.equals("DecisionRule")) || (paramString.equals("DecisionMultiRule")) || (paramString.equals("DecisionRelateRule")) || (paramString.equals("RuleMirror")) || (paramString.equals("ExpressionRule")) || (paramString.equals("RuleTreeFlow")) || (paramString.equals("RulePoolFlow"));
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof IRuleTree)) || ((paramIElement instanceof RulePoolNode)) || ((paramIElement instanceof RuleSetToken)) || ((paramIElement instanceof RulePoolValue));
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
      localObject = new RulePoolFlow(getChildDefaultName(DISPLAYNAME));
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

  public RulePoolNode addNode(String paramString, int paramInt1, int paramInt2)
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
    else if (paramString.equalsIgnoreCase("RULE"))
      localITreeNode = createChildNode("DecisionRelateRule", false);
    else if (paramString.equalsIgnoreCase("DECISIONRELATERULE"))
      localITreeNode = createChildNode("DecisionRelateRule", false);
    updateTree();
    if (localITreeNode != null)
      return addFlowActivitie(localITreeNode.getUuid(), paramString, paramInt1, paramInt2);
    return addFlowActivitie("", paramString, paramInt1, paramInt2);
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

  public RulePoolNode addFlowActivitie(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    RulePoolNode localRulePoolNode = new RulePoolNode(paramString1, paramInt1, paramInt2, paramString2);
    addChildElement(localRulePoolNode);
    return localRulePoolNode;
  }

  public RulePoolNode addFlowActivitie(String paramString1, String paramString2)
  {
    RulePoolNode localRulePoolNode = new RulePoolNode(paramString1, 200, getMaxY(200) + 50, paramString2);
    addChildElement(localRulePoolNode);
    return localRulePoolNode;
  }

  public int getMaxY(int paramInt)
  {
    List localList = a();
    int i = 0;
    for (int j = localList.size() - 1; j >= 0; j--)
    {
      if ((!(localList.get(j) instanceof RulePoolNode)) || (((RulePoolNode)localList.get(j)).getX() < paramInt) || (paramInt > ((RulePoolNode)localList.get(j)).getX() + ((RulePoolNode)localList.get(j)).getWidth()) || (((RulePoolNode)localList.get(j)).getY() <= i))
        continue;
      i = ((RulePoolNode)localList.get(j)).getY();
    }
    return i;
  }

  private RulePoolNode a(String paramString)
  {
    List localList = a();
    RulePoolNode localRulePoolNode;
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      if (!(localList.get(i) instanceof RulePoolNode))
        continue;
      localRulePoolNode = (RulePoolNode)localList.get(i);
      if (localRulePoolNode.getFlowUuid().equalsIgnoreCase(paramString))
        return localRulePoolNode;
    }
    for (i = localList.size() - 1; i >= 0; i--)
    {
      if (!(localList.get(i) instanceof RulePoolNode))
        continue;
      localRulePoolNode = (RulePoolNode)localList.get(i);
      if (localRulePoolNode.getRuleUuid().equalsIgnoreCase(paramString))
        return localRulePoolNode;
    }
    return null;
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

  public String getFlowXml()
  {
    Element localElement1 = new Element("WorkflowProcess");
    Element localElement2 = new Element("Activities");
    List localList = a();
    RulePoolNode localRulePoolNode = getStartTransitions();
    Element localElement3 = new Element("Transitions");
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof RuleFlowActivitie))
        continue;
      RuleFlowActivitie localRuleFlowActivitie = (RuleFlowActivitie)localList.get(i);
      Element localElement4 = new Element("Activitie");
      if (localRuleFlowActivitie.getFlowUuid().length() > 0)
        localElement4.setAttribute("id", localRuleFlowActivitie.getFlowUuid());
      else
        localElement4.setAttribute("id", localRuleFlowActivitie.getUuid());
      if (!StringUtil.isEmpty(localRuleFlowActivitie.getRuleUuid()))
        localElement4.setAttribute("ruleid", localRuleFlowActivitie.getRuleUuid());
      else if (localRuleFlowActivitie.getFlowUuid().length() > 0)
        localElement4.setAttribute("ruleid", localRuleFlowActivitie.getFlowUuid());
      else
        localElement4.setAttribute("ruleid", localRuleFlowActivitie.getUuid());
      localElement4.setAttribute("type", localRuleFlowActivitie.getState());
      localElement4.setAttribute("name", localRuleFlowActivitie.getDisplayName());
      localElement4.setAttribute("xCoordinate", localRuleFlowActivitie.getX());
      localElement4.setAttribute("yCoordinate", localRuleFlowActivitie.getY());
      localElement4.setAttribute("width", localRuleFlowActivitie.getWidth());
      localElement4.setAttribute("height", localRuleFlowActivitie.getHeight());
      localElement2.addContent(localElement4);
      if (localRuleFlowActivitie.isStartNode())
        continue;
      Element localElement5 = new Element("Transition");
      localElement5.setAttribute("id", localRuleFlowActivitie.getUuid());
      localElement5.setAttribute("name", "");
      localElement5.setAttribute("from", localRulePoolNode.getFlowUuid());
      localElement5.setAttribute("to", localRuleFlowActivitie.getFlowUuid());
      localElement3.addContent(localElement5);
    }
    localElement1.addContent(localElement2);
    localElement1.addContent(localElement3);
    return new XMLOutputter().outputString(new Document(localElement1));
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
    if (getPoolNodes().size() > 0)
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.flow.RulePoolFlow
 * JD-Core Version:    0.6.0
 */