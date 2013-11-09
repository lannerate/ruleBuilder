package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.util.ListUtil;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class RuleTreeFlow extends AbstractRuleFlow
  implements IDebugNode, IRuleFlow, IRuleSet, IRuleTree, am
{
  public static final String NAME = "RuleTreeFlow";
  public static final String DISPLAYNAME = getLocalString("RuleTreeFlow.text");
  public static final String COMMNAME = getLocalString("RuleTreeFlow.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("RuleTreeFlow", DISPLAYNAME, DISPLAYNAME);

  public RuleTreeFlow()
  {
  }

  public RuleTreeFlow(RuleTreeFlow paramRuleTreeFlow)
  {
    super(paramRuleTreeFlow);
  }

  public RuleTreeFlow(String paramString)
  {
    super(paramString);
    setEditType(0);
    addChildElement(new RuleFlowActivitie(getUuid(), 150, 20, "START_NODE"));
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRuleTreeFlow(this);
  }

  public IElement deepClone()
  {
    return new RuleTreeFlow(this);
  }

  public String getName()
  {
    return "RuleTreeFlow";
  }

  public Object getFlowElement(String paramString)
  {
    List localList = a();
    for (int i = localList.size() - 1; i >= 0; i--)
      if ((localList.get(i) instanceof RuleFlowActivitie))
      {
        if ((((RuleFlowActivitie)localList.get(i)).getFlowUuid().equalsIgnoreCase(paramString)) || (((RuleFlowActivitie)localList.get(i)).getUuid().equalsIgnoreCase(paramString)))
          return localList.get(i);
      }
      else
      {
        if (!(localList.get(i) instanceof RuleFlowTransition))
          continue;
        RuleFlowTransition localRuleFlowTransition = (RuleFlowTransition)localList.get(i);
        if (localRuleFlowTransition.getUuid().equalsIgnoreCase(paramString))
          return localRuleFlowTransition;
      }
    return null;
  }

  public String getFlowXml()
  {
    Element localElement1 = new Element("WorkflowProcess");
    Element localElement2 = new Element("Activities");
    List localList = a();
    Object localObject;
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof RuleFlowActivitie))
        continue;
      RuleFlowActivitie localRuleFlowActivitie = (RuleFlowActivitie)localList.get(i);
      localObject = new Element("Activitie");
      if (localRuleFlowActivitie.getFlowUuid().length() > 0)
        ((Element)localObject).setAttribute("id", localRuleFlowActivitie.getFlowUuid());
      else
        ((Element)localObject).setAttribute("id", localRuleFlowActivitie.getUuid());
      if (!StringUtil.isEmpty(localRuleFlowActivitie.getRuleUuid()))
        ((Element)localObject).setAttribute("ruleid", localRuleFlowActivitie.getRuleUuid());
      else if (localRuleFlowActivitie.getFlowUuid().length() > 0)
        ((Element)localObject).setAttribute("ruleid", localRuleFlowActivitie.getFlowUuid());
      else
        ((Element)localObject).setAttribute("ruleid", localRuleFlowActivitie.getUuid());
      ((Element)localObject).setAttribute("type", localRuleFlowActivitie.getState());
      ((Element)localObject).setAttribute("name", localRuleFlowActivitie.getDisplayName());
      ((Element)localObject).setAttribute("xCoordinate", localRuleFlowActivitie.getX());
      ((Element)localObject).setAttribute("yCoordinate", localRuleFlowActivitie.getY());
      ((Element)localObject).setAttribute("width", localRuleFlowActivitie.getWidth());
      ((Element)localObject).setAttribute("height", localRuleFlowActivitie.getHeight());
      localElement2.addContent((Content)localObject);
    }
    localElement1.addContent(localElement2);
    Element localElement3 = new Element("Transitions");
    for (int j = 0; j < localList.size(); j++)
    {
      if (!(localList.get(j) instanceof RuleFlowTransition))
        continue;
      localObject = (RuleFlowTransition)localList.get(j);
      Element localElement4 = new Element("Transition");
      localElement4.setAttribute("id", ((RuleFlowTransition)localObject).getUuid());
      localElement4.setAttribute("name", ((RuleFlowTransition)localObject).getInfo());
      localElement4.setAttribute("from", ((RuleFlowTransition)localObject).getFromUuid());
      localElement4.setAttribute("to", ((RuleFlowTransition)localObject).getToUuid());
      localElement3.addContent(localElement4);
    }
    localElement1.addContent(localElement3);
    return (String)new XMLOutputter().outputString(new Document(localElement1));
  }

  private void b(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    List localList = a();
    int i = 0;
    for (int j = localList.size() - 1; j >= 0; j--)
    {
      if (!(localList.get(j) instanceof RuleFlowTransition))
        continue;
      RuleFlowTransition localRuleFlowTransition = (RuleFlowTransition)localList.get(j);
      if (localRuleFlowTransition.getFromUuid().equalsIgnoreCase(paramString))
        localArrayList2.add(localRuleFlowTransition);
      if (!localRuleFlowTransition.getToUuid().equalsIgnoreCase(paramString))
        continue;
      localArrayList1.add(localRuleFlowTransition);
    }
    if ((localArrayList2.size() == 1) && (localArrayList1.size() == 1))
      ((RuleFlowTransition)localArrayList1.get(0)).setToUuid(((RuleFlowTransition)localArrayList2.get(0)).getToUuid());
  }

  public boolean removeFlowElements(String paramString)
  {
    List localList = a();
    int i = 0;
    Object localObject;
    for (int j = localList.size() - 1; j >= 0; j--)
    {
      if (!(localList.get(j) instanceof RuleFlowActivitie))
        continue;
      localObject = (RuleFlowActivitie)localList.get(j);
      if ((!((RuleFlowActivitie)localObject).getFlowUuid().equalsIgnoreCase(paramString)) && (!((RuleFlowActivitie)localObject).getRuleUuid().equalsIgnoreCase(paramString)))
        continue;
      if (((RuleFlowActivitie)localObject).isPointNode())
        b(paramString);
      ((RuleFlowActivitie)localObject).dispose();
      i = 1;
    }
    for (j = localList.size() - 1; j >= 0; j--)
    {
      if (!(localList.get(j) instanceof RuleFlowTransition))
        continue;
      localObject = (RuleFlowTransition)localList.get(j);
      if (((RuleFlowTransition)localObject).getFromUuid().equalsIgnoreCase(paramString))
        ((RuleFlowTransition)localObject).dispose();
      if (!((RuleFlowTransition)localObject).getToUuid().equalsIgnoreCase(paramString))
        continue;
      ((RuleFlowTransition)localObject).dispose();
    }
    return i;
  }

  public IRuleClass getRuleObject(RuleFlowActivitie paramRuleFlowActivitie)
  {
    Iterator localIterator = getRootParent().getAcceptElements(new aA(this));
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((localObject instanceof IRuleClass)) && (((IRuleClass)localObject).getUuid().equalsIgnoreCase(paramRuleFlowActivitie.getRuleUuid())))
        return (IRuleClass)localObject;
    }
    localIterator = getRootParent().getAcceptElements(new aB(this));
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((localObject instanceof IRulePackage)) && (((IRulePackage)localObject).getExeRulePackageName().equalsIgnoreCase(paramRuleFlowActivitie.getExeRuleName())))
        return (IRulePackage)localObject;
      if (!(localObject instanceof IRuleTree))
        continue;
      IRuleTree localIRuleTree = (IRuleTree)localObject;
      if (StringUtil.isEmpty(paramRuleFlowActivitie.getExeRuleName()))
      {
        if ((localIRuleTree.getMainPackage().equals(getMainPackage())) && (localIRuleTree.getDisplayName().equals(paramRuleFlowActivitie.getExeRuleDisplay())))
          return localIRuleTree;
      }
      else if (paramRuleFlowActivitie.getExeRuleName().equals(localIRuleTree.getMainPackage().getExeRulePackageName() + localIRuleTree.getVisitRuleName()))
        return localIRuleTree;
    }
    return null;
  }

  public List getStartTransitions()
  {
    List localList = a();
    for (int i = localList.size() - 1; i >= 0; i--)
    {
      if (!(localList.get(i) instanceof RuleFlowActivitie))
        continue;
      RuleFlowActivitie localRuleFlowActivitie = (RuleFlowActivitie)localList.get(i);
      if (localRuleFlowActivitie.isStartNode())
        return getNextTransitions(localRuleFlowActivitie.getFlowUuid());
    }
    return ListUtil.EMPTYLIST;
  }

  protected boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Math.abs(paramInt2 - paramInt4) <= 10)
      return paramInt1 > paramInt3;
    if (Math.abs(paramInt1 - paramInt3) <= 10)
      return paramInt2 > paramInt4;
    return paramInt1 > paramInt3;
  }

  protected void a(RuleFlowTransition paramRuleFlowTransition, List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      RuleFlowTransition localRuleFlowTransition = (RuleFlowTransition)paramList.get(i);
      RuleFlowActivitie localRuleFlowActivitie1 = a(localRuleFlowTransition.getToUuid());
      RuleFlowActivitie localRuleFlowActivitie2 = a(paramRuleFlowTransition.getToUuid());
      if ((localRuleFlowActivitie1 == null) || (localRuleFlowActivitie2 == null) || (!a(localRuleFlowActivitie1.getX(), localRuleFlowActivitie1.getY(), localRuleFlowActivitie2.getX(), localRuleFlowActivitie2.getY())))
        continue;
      paramList.add(i, paramRuleFlowTransition);
      return;
    }
    paramList.add(paramRuleFlowTransition);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.RuleTreeFlow
 * JD-Core Version:    0.6.0
 */