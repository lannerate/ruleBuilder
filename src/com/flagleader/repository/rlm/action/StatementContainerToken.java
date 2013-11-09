package com.flagleader.repository.rlm.action;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.c.a;
import com.flagleader.repository.k;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.ModifyToken;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.IModifierEditen;
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IStatementContainerToken;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StatementContainerToken extends AbstractRuleObject
  implements ILineEditen, IMultiEditen, IStatementContainerToken
{
  private transient StatementContainerToken.ActionTypeToken typeJudgeToken = null;
  private transient ModifyToken disposeModifier = null;
  private static final String REMOVEACTION = "&remove";
  private transient k[] popupEvents = { new u(this), new F(this), new I(this), new J(this), new K(this), new L(this), new M(this), new N(this), new O(this), new v(this), new w(this), new x(this), new y(this), new z(this), new A(this), new B(this), new C(this), new D(this), new E(this), new G(this), new H(this) };
  private static final String[] ruleActions = com.flagleader.repository.d.u.b("RuleAction.select");
  private static final String[] RuleInits = com.flagleader.repository.d.u.b("RuleInit.select");
  private static final String[] ruleActionseditor = com.flagleader.repository.d.u.b("RuleAction.editor");
  private static final String[] RuleInitseditor = com.flagleader.repository.d.u.b("RuleInit.editor");

  public StatementContainerToken()
  {
  }

  public StatementContainerToken(StatementContainerToken paramStatementContainerToken)
  {
    super(paramStatementContainerToken);
  }

  public int getEventCount()
  {
    if ((getRoot() != null) && (getRoot().getRuleTree().isDevelopModel()))
    {
      if (isInit())
        return RuleInits.length;
      return ruleActions.length;
    }
    if (isInit())
      return RuleInitseditor.length;
    return ruleActionseditor.length;
  }

  public boolean isInit()
  {
    return (getParent() != null) && ((getParent() instanceof IMultiActionToken)) && ((((IMultiActionToken)getParent()).getType() == 1) || (((IMultiActionToken)getParent()).getType() == 2));
  }

  public IStatementToken getStatement()
  {
    Iterator localIterator = getChildrenIterator();
    if (localIterator.hasNext())
      return (IStatementToken)localIterator.next();
    return null;
  }

  public void addChildElement(IElement paramIElement)
  {
    clearAllChildren();
    super.addChildElement(paramIElement);
  }

  public StatementContainerToken.ActionTypeToken getActionTypeToken()
  {
    if (this.typeJudgeToken == null)
      a(new StatementContainerToken.ActionTypeToken(this));
    return this.typeJudgeToken;
  }

  private void a(StatementContainerToken.ActionTypeToken paramActionTypeToken)
  {
    this.typeJudgeToken = paramActionTypeToken;
    this.typeJudgeToken.setParent(this);
  }

  protected boolean a(IElement paramIElement)
  {
    return (paramIElement instanceof IStatementToken);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitActionToken(this);
  }

  public IModifierEditen getDisposeModifier()
  {
    if (this.disposeModifier == null)
      setDisposeModifier(new StatementContainerToken.DeleteToken(this, "&remove", new P(this)));
    return this.disposeModifier;
  }

  public void setDisposeModifier(ModifyToken paramModifyToken)
  {
    this.disposeModifier = paramModifyToken;
    this.disposeModifier.setParent(this);
  }

  public Iterator getMultiToken()
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = false;
    if (getRoot() != null)
      bool = getRoot().isLocked();
    if ((!bool) && (getActionTypeToken() != null))
      localArrayList.add(getActionTypeToken());
    if (getStatement() != null)
      localArrayList.add(getStatement());
    if ((!bool) && (getDisposeModifier() != null))
      localArrayList.add(getDisposeModifier());
    return localArrayList.iterator();
  }

  public String toString()
  {
    Iterator localIterator = getMultiToken();
    StringBuffer localStringBuffer = new StringBuffer();
    while (localIterator.hasNext())
      localStringBuffer.append(localIterator.next());
    return localStringBuffer.toString();
  }

  public IElement deepClone()
  {
    return new StatementContainerToken(this);
  }

  public String getName()
  {
    return "StatementContainerToken";
  }

  public boolean canPasteElement(IElement paramIElement)
  {
    return (paramIElement != null) && (((paramIElement instanceof StatementContainerToken)) || ((paramIElement instanceof ElementContainer))) && (getParent() != null);
  }

  public IElement copyElement()
  {
    return deepClone();
  }

  public IElement cutElement()
  {
    IElement localIElement = deepClone();
    IRuleContainer localIRuleContainer = getRoot();
    localIRuleContainer.initUndoable();
    dispose();
    localIRuleContainer.setModified(true);
    localIRuleContainer.takeSnapshot();
    return localIElement;
  }

  public boolean pasteElement(IElement paramIElement)
  {
    if (canPasteElement(paramIElement))
    {
      h();
      if ((paramIElement instanceof StatementContainerToken))
      {
        getParent().addChildElement(paramIElement, getParent().getElementPos(this));
      }
      else if ((paramIElement instanceof ElementContainer))
      {
        int i = getParent().getElementPos(this);
        Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (!(localObject instanceof StatementContainerToken))
            continue;
          getParent().addChildElement((StatementContainerToken)localObject, i++);
        }
      }
      g();
      return true;
    }
    return false;
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean canCut()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.StatementContainerToken
 * JD-Core Version:    0.6.0
 */