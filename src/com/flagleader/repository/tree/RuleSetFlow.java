package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import java.util.Iterator;
import java.util.List;
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class RuleSetFlow extends AbstractRuleFlow
  implements IDebugNode, IRuleFlow, IRuleSet, IRuleTree, am
{
  public static final String NAME = "RuleSetFlow";
  public static final String DISPLAYNAME = getLocalString("RuleSetFlow.text");
  public static final String COMMNAME = getLocalString("RuleSetFlow.comm");
  public static final NodeInfo nodeInfo = new NodeInfo("RuleSetFlow", DISPLAYNAME, DISPLAYNAME);

  public RuleSetFlow()
  {
  }

  public RuleSetFlow(RuleSetFlow paramRuleSetFlow)
  {
    super(paramRuleSetFlow);
  }

  public RuleSetFlow(String paramString)
  {
    super(paramString);
    setEditType(0);
    addChildElement(new RuleFlowActivitie(getUuid(), 0, 100, "START_NODE"));
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRuleSetFlow(this);
  }

  public IElement deepClone()
  {
    return new RuleSetFlow(this);
  }

  public String getName()
  {
    return "RuleSetFlow";
  }

  public Object getFlowElement(String paramString)
  {
    List localList = a();
    for (int i = localList.size() - 1; i >= 0; i--)
      if ((localList.get(i) instanceof RuleFlowActivitie))
      {
        if ((((RuleFlowActivitie)localList.get(i)).getRuleUuid().equalsIgnoreCase(paramString)) || (((RuleFlowActivitie)localList.get(i)).getUuid().equalsIgnoreCase(paramString)))
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
      if (localRuleFlowActivitie.getRuleUuid().length() > 0)
        ((Element)localObject).setAttribute("id", localRuleFlowActivitie.getRuleUuid());
      else
        ((Element)localObject).setAttribute("id", localRuleFlowActivitie.getUuid());
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

  public boolean removeFlowElements(String paramString)
  {
    List localList = a();
    int i = 0;
    for (int j = localList.size() - 1; j >= 0; j--)
      if ((localList.get(j) instanceof RuleFlowActivitie))
      {
        if ((!((RuleFlowActivitie)localList.get(j)).getRuleUuid().equalsIgnoreCase(paramString)) && (!((RuleFlowActivitie)localList.get(j)).getUuid().equalsIgnoreCase(paramString)))
          continue;
        ((RuleFlowActivitie)localList.get(j)).dispose();
        i = 1;
      }
      else
      {
        if (!(localList.get(j) instanceof RuleFlowTransition))
          continue;
        RuleFlowTransition localRuleFlowTransition = (RuleFlowTransition)localList.get(j);
        if (localRuleFlowTransition.getFromUuid().equalsIgnoreCase(paramString))
          localRuleFlowTransition.dispose();
        if (!localRuleFlowTransition.getToUuid().equalsIgnoreCase(paramString))
          continue;
        localRuleFlowTransition.dispose();
      }
    return i;
  }

  public IRuleClass getRuleObject(RuleFlowActivitie paramRuleFlowActivitie)
  {
    Iterator localIterator = getChildrenIterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((localObject instanceof IRuleClass)) && (((IRuleClass)localObject).getUuid().equalsIgnoreCase(paramRuleFlowActivitie.getRuleUuid())))
        return (IRuleClass)localObject;
    }
    localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((localObject instanceof IRuleClass)) && (((IRuleClass)localObject).getDisplayName().equalsIgnoreCase(paramRuleFlowActivitie.getExeRuleDisplay())))
        return (IRuleClass)localObject;
    }
    return null;
  }

  public List getStartTransitions()
  {
    return getNextTransitions(getUuid());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.RuleSetFlow
 * JD-Core Version:    0.6.0
 */