package com.flagleader.repository.flow;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.action.AbstractSelectRuleToken;
import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleMirror;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.RuleSetFlow;
import com.flagleader.repository.tree.RuleTreeFlow;
import com.flagleader.util.StringUtil;
import java.util.Iterator;

public class RulePoolNode extends AbstractSelectRuleToken
  implements ISelectRulePackageEditen
{
  private String ruleUuid = "";
  private String flowUuid = "";
  private int x = 0;
  private int y = 100;
  private int width = 80;
  private int height = 30;
  private String state = "";
  public static final String RULE = "RULE";
  public static final String RULEPACKAGE = "RULEPACKAGE";
  public static final String RULESET = "RULESET";
  public static final String DECISIONRULE = "DECISIONRULE";
  public static final String DECISIONMULTIRULE = "DECISIONMULTIRULE";
  public static final String EXPRESSIONRULE = "EXPRESSIONRULE";
  public static final String DECISIONRELATERULE = "DECISIONRELATERULE";
  public static final String RULEMIRROR = "RULEMIRROR";
  public static final String RULESETFLOW = "RULESETFLOW";
  public static final String RULETREEFLOW = "RULETREEFLOW";
  public static final String RULEPOOLFLOW = "RULEPOOLFLOW";
  public static final String START_NODE = "START_NODE";
  public static final String END_NODE = "END_NODE";

  public RulePoolNode(RulePoolNode paramRulePoolNode)
  {
    super(paramRulePoolNode);
    this.ruleUuid = paramRulePoolNode.ruleUuid;
    this.x = paramRulePoolNode.x;
    this.y = paramRulePoolNode.y;
    this.width = paramRulePoolNode.width;
    this.height = paramRulePoolNode.height;
    this.state = paramRulePoolNode.state;
    this.flowUuid = paramRulePoolNode.flowUuid;
    setUuid(paramRulePoolNode.getUuid());
  }

  public RulePoolNode()
  {
  }

  public RulePoolNode(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.ruleUuid = paramString1;
    this.x = paramInt1;
    this.y = paramInt2;
    this.state = paramString2;
    this.flowUuid = getUuid();
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRulePoolNode(this);
  }

  public IElement deepClone()
  {
    return new RulePoolNode(this);
  }

  public String getName()
  {
    return "RulePoolNode";
  }

  public String toString()
  {
    return getDisplayName();
  }

  public String getRuleUuid()
  {
    return this.ruleUuid;
  }

  public void setRuleUuid(String paramString)
  {
    this.ruleUuid = paramString;
  }

  public IRuleClass getRuleObject()
  {
    if ((getParent() instanceof RulePoolFlow))
      return ((RulePoolFlow)getParent()).getRuleObject(this);
    return null;
  }

  public String getImageName()
  {
    String str = getState();
    if (str.equals("RULE"))
      return "Rule";
    if (str.equals("RULESET"))
      return "RuleSet";
    if (str.equals("RULEPACKAGE"))
      return "RulePackage";
    if (str.equals("DECISIONRULE"))
      return "DecisionRule";
    if (str.equals("DECISIONMULTIRULE"))
      return "DecisionMultiRule";
    if (str.equals("EXPRESSIONRULE"))
      return "ExpressionRule";
    if (str.equals("DECISIONRELATERULE"))
      return "DecisionRelateRule";
    if (str.equals("RULESETFLOW"))
      return "RuleSetFlow";
    if (str.equals("RULETREEFLOW"))
      return "RuleTreeFlow";
    if (str.equals("RULEPOOLFLOW"))
      return "RulePoolFlow";
    if (str.equals("RULEMIRROR"))
      return "RuleMirror";
    if (str.equals("START_NODE"))
      return "go";
    if (str.equals("END_NODE"))
      return "stop";
    return "Rule";
  }

  public String getState()
  {
    if (this.state.length() > 0)
      return this.state;
    IRuleClass localIRuleClass = getRuleObject();
    return getElementState(localIRuleClass);
  }

  public boolean isStartNode()
  {
    return this.state.equals("START_NODE");
  }

  public boolean isEndNode()
  {
    return this.state.equals("END_NODE");
  }

  public static String getElementState(IElement paramIElement)
  {
    if (paramIElement == null)
      return "";
    if ((paramIElement instanceof Rule))
      return "RULE";
    if ((paramIElement instanceof RuleSet))
      return "RULESET";
    if ((paramIElement instanceof DecisionRule))
      return "DECISIONRULE";
    if ((paramIElement instanceof DecisionMultiRule))
      return "DECISIONMULTIRULE";
    if ((paramIElement instanceof ExpressionRule))
      return "EXPRESSIONRULE";
    if ((paramIElement instanceof DecisionRelateRule))
      return "DECISIONRELATERULE";
    if ((paramIElement instanceof RuleSetFlow))
      return "RULESETFLOW";
    if ((paramIElement instanceof RuleTreeFlow))
      return "RULETREEFLOW";
    if ((paramIElement instanceof RulePoolFlow))
      return "RULEPOOLFLOW";
    if ((paramIElement instanceof RuleMirror))
      return "RULEMIRROR";
    if ((paramIElement instanceof RulePackage))
      return "RULEPACKAGE";
    return "";
  }

  public String getDisplayName()
  {
    if ((isStartNode()) && ((getParent() instanceof RulePoolFlow)))
      return ((RulePoolFlow)getParent()).getValuesDisplay();
    if (getRuleObject() != null)
      return getRuleObject().getDisplayName();
    return getExeRuleDisplay();
  }

  public int getHeight()
  {
    return this.height;
  }

  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }

  public int getWidth()
  {
    return this.width;
  }

  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }

  public int getX()
  {
    return this.x;
  }

  public void setX(int paramInt)
  {
    this.x = paramInt;
  }

  public int getY()
  {
    return this.y;
  }

  public void setY(int paramInt)
  {
    this.y = paramInt;
  }

  public void setState(String paramString)
  {
    this.state = paramString;
  }

  public String getFlowUuid()
  {
    if (StringUtil.isEmpty(this.flowUuid))
    {
      if (StringUtil.isEmpty(this.ruleUuid))
        return getUuid();
      return this.ruleUuid;
    }
    return this.flowUuid;
  }

  public void setFlowUuid(String paramString)
  {
    this.flowUuid = paramString;
  }

  public void setModified(boolean paramBoolean)
  {
    if (getRuleObject() != null)
      getRuleObject().setModified(paramBoolean);
  }

  public void update()
  {
    if ((getParent() instanceof RuleSetFlow))
      ((RuleSetFlow)getParent()).updateViewer();
    else if ((getParent() instanceof RulePoolFlow))
      ((RulePoolFlow)getParent()).updateViewer();
  }

  public Envionment getEnvionment()
  {
    return getRuleObject().getEnvionment();
  }

  protected IRuleClass a(String paramString1, String paramString2)
  {
    IElement localIElement = getRootParent();
    Iterator localIterator = null;
    if (((localIElement instanceof IRuleRepository)) || ((localIElement instanceof IRuleProject)))
    {
      localIterator = localIElement.getAcceptElements(new c(this, paramString1));
      if (localIterator.hasNext())
        return (IRuleClass)localIterator.next();
      localIterator = localIElement.getAcceptElements(new d(this, paramString2));
      if (localIterator.hasNext())
        return (IRuleClass)localIterator.next();
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.flow.RulePoolNode
 * JD-Core Version:    0.6.0
 */