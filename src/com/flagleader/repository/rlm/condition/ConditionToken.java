package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.expression.j;
import com.flagleader.repository.lang.expression.w;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.ModifyToken;
import com.flagleader.repository.rlm.StaticTextToken;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.IModifierEditen;
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.IJudgeToken;
import com.flagleader.repository.rlm.lang.ILogicalToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rlm.value.ConstantSelectToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConditionToken extends AbstractRuleObject
  implements ILineEditen, IMultiEditen, IConditionToken
{
  private int leftParenthesisNumber = 0;
  private int rightParenthesisNumber = 0;
  private transient ModifyToken disposeModifier = null;
  private int opeType = 0;

  public ConditionToken(ConditionToken paramConditionToken)
  {
    super(paramConditionToken);
    this.leftParenthesisNumber = paramConditionToken.leftParenthesisNumber;
    this.rightParenthesisNumber = paramConditionToken.rightParenthesisNumber;
    this.opeType = paramConditionToken.opeType;
  }

  public ConditionToken()
  {
  }

  protected void b(IElement paramIElement)
  {
    if ((paramIElement == null) || (!(paramIElement instanceof IBusinessObject)))
      return;
    if (isForceOperationType())
      return;
    g localg = ((IBusinessObject)paramIElement).getJavaType();
    h();
    if (getCompareOperator() != null)
    {
      if (((getCompareOperator() instanceof StringJudgeToken)) && (!localg.m()))
        removeChildElement(getCompareOperator());
      if (((getCompareOperator() instanceof NumberJudgeToken)) && (!localg.b()) && (!localg.d()))
        removeChildElement(getCompareOperator());
      if (((getCompareOperator() instanceof DecimalJudgeToken)) && (!localg.j()))
        removeChildElement(getCompareOperator());
      if (((getCompareOperator() instanceof ClassJudgeToken)) && (!localg.p()) && (!localg.z()))
        removeChildElement(getCompareOperator());
      if (((getCompareOperator() instanceof BooleanJudgeToken)) && (!localg.e()))
        removeChildElement(getCompareOperator());
      if (((getCompareOperator() instanceof DateJudgeToken)) && (!localg.v()) && (!localg.w()) && (!localg.x()))
        removeChildElement(getCompareOperator());
    }
    if (getCompareOperator() == null)
    {
      if (localg.m())
        addChildElement(createStringJudge());
      else if ((localg.b()) || (localg.d()))
        addChildElement(new NumberJudgeToken());
      else if (localg.j())
        addChildElement(new DecimalJudgeToken(new b(this, localg.K())));
      else if ((localg.v()) || (localg.w()) || (localg.x()))
        addChildElement(new DateJudgeToken(new a(this, localg.K())));
      else if (localg.e())
        addChildElement(new BooleanJudgeToken());
      else if ((localg.p()) || (localg.z()))
        addChildElement(new ClassJudgeToken());
      if (getComparedValue() != null)
        removeChildElement(getComparedValue());
      if ((localg.b()) || (localg.m()) || (localg.j()))
        a(new ValueToken(2, localg.K(), ""));
      else if ((localg.d()) || (localg.v()) || (localg.w()) || (localg.x()))
        a(new ValueToken(1, localg.K(), ""));
    }
    g();
    update();
  }

  public boolean isForceString(int paramInt)
  {
    return paramInt == 1;
  }

  public boolean isForceNumber(int paramInt)
  {
    return (paramInt >= 2) && (paramInt <= 4);
  }

  public boolean isForceDecimal(int paramInt)
  {
    return paramInt == 5;
  }

  public boolean isForceDate(int paramInt)
  {
    return paramInt == 6;
  }

  public boolean isForceBoolean(int paramInt)
  {
    return paramInt == 7;
  }

  public boolean isForceClass(int paramInt)
  {
    return paramInt == 8;
  }

  public void changeForceType(int paramInt)
  {
    if ((paramInt == this.opeType) || ((isForceNumber(paramInt)) && (isForceNumber(this.opeType))))
      return;
    if (paramInt == 0)
    {
      if ((getFirstValue() instanceof MemberToken))
        b(((MemberToken)getFirstValue()).getMemberElement());
    }
    else
    {
      h();
      if (getCompareOperator() != null)
      {
        if (((getCompareOperator() instanceof StringJudgeToken)) && (!isForceString(paramInt)))
          removeChildElement(getCompareOperator());
        if (((getCompareOperator() instanceof NumberJudgeToken)) && (!isForceNumber(paramInt)))
          removeChildElement(getCompareOperator());
        if (((getCompareOperator() instanceof DecimalJudgeToken)) && (!isForceDecimal(paramInt)))
          removeChildElement(getCompareOperator());
        if (((getCompareOperator() instanceof ClassJudgeToken)) && (!isForceClass(paramInt)))
          removeChildElement(getCompareOperator());
        if (((getCompareOperator() instanceof BooleanJudgeToken)) && (!isForceBoolean(paramInt)))
          removeChildElement(getCompareOperator());
        if (((getCompareOperator() instanceof DateJudgeToken)) && (!isForceDate(paramInt)))
          removeChildElement(getCompareOperator());
      }
      if (getCompareOperator() == null)
      {
        if (isForceString(paramInt))
          addChildElement(createStringJudge());
        else if (isForceNumber(paramInt))
          addChildElement(new NumberJudgeToken());
        else if (isForceDecimal(paramInt))
          addChildElement(new DecimalJudgeToken(new b(this, getForceTypeName(paramInt))));
        else if (isForceDate(paramInt))
          addChildElement(new DateJudgeToken(new a(this, getForceTypeName(paramInt))));
        else if (isForceBoolean(paramInt))
          addChildElement(new BooleanJudgeToken());
        else if (isForceClass(paramInt))
          addChildElement(new ClassJudgeToken());
        if (getComparedValue() != null)
          removeChildElement(getComparedValue());
        if ((isForceNumber(paramInt)) || (isForceString(paramInt)) || (isForceDecimal(paramInt)))
          a(new ValueToken(2, getForceTypeName(paramInt), ""));
        else if (isForceDate(paramInt))
          a(new ValueToken(1, getForceTypeName(paramInt), ""));
      }
      g();
      update();
    }
  }

  public ConditionToken(j paramj)
  {
    if (!isFirstCondition())
      addChildElement(new LogicalJudgeToken());
    if (paramj.b().size() > 0)
    {
      w localw = (w)paramj.b().get(0);
      this.leftParenthesisNumber = localw.d();
      this.rightParenthesisNumber = localw.e();
    }
  }

  public StringJudgeToken createStringJudge()
  {
    return new StringJudgeToken(new e(this), 12);
  }

  public void init()
  {
    if (!isFirstCondition())
      addChildElement(new LogicalJudgeToken());
    addChildElement(new MemberToken());
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitConditionToken(this);
  }

  public IElement deepClone()
  {
    return new ConditionToken(this);
  }

  public String getName()
  {
    return "ConditionToken";
  }

  public boolean isFirstCondition()
  {
    return (getConditionContainer() != null) && (getConditionContainer().getConditionPos(this) == 0);
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof IValueToken)) || ((paramIElement instanceof IJudgeToken)) || ((paramIElement instanceof IValueContainerToken)) || ((paramIElement instanceof ILogicalToken)) || ((paramIElement instanceof IConditionToken));
  }

  public IValueContainerToken getComparedValue()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof IValueContainerToken))
        return (IValueContainerToken)localObject;
    }
    return null;
  }

  private void a(IValueContainerToken paramIValueContainerToken)
  {
    if (getComparedValue() != null)
      removeChildElement(getComparedValue());
    super.addChildElement(paramIValueContainerToken);
  }

  public IJudgeToken getCompareOperator()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IJudgeToken))
        continue;
      if ((localObject instanceof DateJudgeToken))
      {
        if ((((DateJudgeToken)localObject).getListeners().size() == 0) && (getFirstValue() != null))
          ((DateJudgeToken)localObject).addJudgeTokenListener(new a(this, getFirstValue().getValueType()));
      }
      else if ((localObject instanceof DecimalJudgeToken))
      {
        if ((((DecimalJudgeToken)localObject).getListeners().size() == 0) && (getFirstValue() != null))
          ((DecimalJudgeToken)localObject).addJudgeTokenListener(new b(this, getFirstValue().getValueType()));
      }
      else if (((localObject instanceof StringJudgeToken)) && (((StringJudgeToken)localObject).getListeners().size() == 0))
        ((StringJudgeToken)localObject).addJudgeTokenListener(new e(this));
      return (IJudgeToken)localObject;
    }
    return null;
  }

  public IValueToken getFirstValue()
  {
    Iterator localIterator = getChildrenIterator();
    IValueToken localIValueToken = null;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IValueToken))
        continue;
      localIValueToken = (IValueToken)localObject;
      break;
    }
    return localIValueToken;
  }

  public void addChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof MemberToken))
      ((MemberToken)paramIElement).addElementTokenListener(new d(this));
    super.addChildElement(paramIElement);
  }

  public ILogicalToken getLogicalOperator()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((localObject instanceof LogicalJudgeToken))
        return (LogicalJudgeToken)localObject;
    }
    Object localObject = new LogicalJudgeToken();
    addChildElement((IElement)localObject);
    return (ILogicalToken)localObject;
  }

  public Iterator getNextTests()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IConditionToken))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList.iterator();
  }

  public IMultiConditionToken getConditionContainer()
  {
    if ((getParent() != null) && ((getParent() instanceof IMultiConditionToken)))
      return (IMultiConditionToken)getParent();
    return null;
  }

  public IModifierEditen getDisposeModifier()
  {
    if (this.disposeModifier == null)
      setDisposeModifier(new ConditionToken.DeleteToken(this, "&remove", new c(this)));
    return this.disposeModifier;
  }

  public void setDisposeModifier(ModifyToken paramModifyToken)
  {
    this.disposeModifier = paramModifyToken;
    this.disposeModifier.setParent(this);
  }

  public ConstantToken getConstantValue()
  {
    if ((getComparedValue() != null) && (getComparedValue().getNextValue() == null) && ((getComparedValue().getValueElement() instanceof ConstantToken)))
      return (ConstantToken)getComparedValue().getValueElement();
    return null;
  }

  public ConstantSelectToken getComboValue()
  {
    if ((getComparedValue() != null) && (getComparedValue().getNextValue() == null) && ((getComparedValue().getValueElement() instanceof ConstantSelectToken)))
      return (ConstantSelectToken)getComparedValue().getValueElement();
    return null;
  }

  public void setValue(ConstantEnum paramConstantEnum)
  {
    if ((getComparedValue() != null) && (getComparedValue().getValueElement() != null) && ((getComparedValue().getValueElement() instanceof ConstantSelectToken)))
      ((ConstantSelectToken)getComparedValue().getValueElement()).setMemberElement(paramConstantEnum);
  }

  public List getComboEnums()
  {
    if (((getFirstValue() instanceof MemberToken)) && ((((MemberToken)getFirstValue()).getMemberElement() instanceof IBusinessObject)))
    {
      IBusinessObject localIBusinessObject = (IBusinessObject)((MemberToken)getFirstValue()).getMemberElement();
      if (localIBusinessObject != null)
      {
        Iterator localIterator = getEnvionment().getEnums(localIBusinessObject.getValueType(), localIBusinessObject.getDisplayName());
        if (localIterator.hasNext())
        {
          ArrayList localArrayList = new ArrayList();
          while (localIterator.hasNext())
            localArrayList.add(localIterator.next());
          return localArrayList;
        }
      }
    }
    return null;
  }

  public Iterator getMultiToken()
  {
    ArrayList localArrayList = new ArrayList();
    if (!isFirstCondition())
      localArrayList.add(getLogicalOperator());
    int i;
    if ((getLeftParenthesisNumber() > 0) || (getNextTests().hasNext()))
    {
      localObject = "";
      for (i = 0; i < getLeftParenthesisNumber(); i++)
        localObject = localObject + "( ";
      if (getNextTests().hasNext())
        localObject = localObject + "( ";
      localArrayList.add(new StaticTextToken((String)localObject, "parenthsis"));
    }
    if (getFirstValue() != null)
      localArrayList.add(getFirstValue());
    if (getCompareOperator() != null)
      localArrayList.add(getCompareOperator());
    if (getComparedValue() != null)
      localArrayList.add(getComparedValue());
    if (getRightParenthesisNumber() > 0)
    {
      localObject = "";
      for (i = 0; i < getRightParenthesisNumber(); i++)
        localObject = localObject + ") ";
      localArrayList.add(new StaticTextToken((String)localObject, "parenthsis"));
    }
    Object localObject = getNextTests();
    while (((Iterator)localObject).hasNext())
    {
      IConditionToken localIConditionToken = (IConditionToken)((Iterator)localObject).next();
      localArrayList.add(localIConditionToken.getLogicalOperator());
      if (localIConditionToken.getLeftParenthesisNumber() > 0)
      {
        str = "";
        for (j = 0; j < localIConditionToken.getLeftParenthesisNumber(); j++)
          str = str + "( ";
        localArrayList.add(new StaticTextToken(str, "parenthsis"));
      }
      if (localIConditionToken.getFirstValue() != null)
        localArrayList.add(localIConditionToken.getFirstValue());
      if (localIConditionToken.getCompareOperator() != null)
        localArrayList.add(localIConditionToken.getCompareOperator());
      if (localIConditionToken.getComparedValue() != null)
        localArrayList.add(localIConditionToken.getComparedValue());
      if (localIConditionToken.getRightParenthesisNumber() <= 0)
        continue;
      String str = "";
      for (int j = 0; j < localIConditionToken.getRightParenthesisNumber(); j++)
        str = str + ") ";
      localArrayList.add(new StaticTextToken(str, "parenthsis"));
    }
    if (getNextTests().hasNext())
      localArrayList.add(new StaticTextToken(") ", "parenthsis"));
    boolean bool = false;
    if (getRoot() != null)
      bool = getRoot().isLocked();
    if ((!bool) && (getDisposeModifier() != null))
      localArrayList.add(getDisposeModifier());
    return (Iterator)localArrayList.iterator();
  }

  public void changeValueType(String paramString)
  {
    g localg = getTypeManager().a(paramString);
    if (getFirstValue() != null)
      getFirstValue().setValueType(paramString);
    if (getCompareOperator() != null)
    {
      IJudgeToken localIJudgeToken = getCompareOperator();
      int i = localIJudgeToken.getType();
      int j = 0;
      if (((localIJudgeToken instanceof StringJudgeToken)) && (!localg.m()))
      {
        super.removeChildElement(localIJudgeToken);
        j = 1;
      }
      else if (((localIJudgeToken instanceof NumberJudgeToken)) && (!localg.b()) && (!localg.d()))
      {
        super.removeChildElement(localIJudgeToken);
        j = 1;
      }
      else if (((localIJudgeToken instanceof DecimalJudgeToken)) && (!localg.j()))
      {
        super.removeChildElement(localIJudgeToken);
        j = 1;
      }
      else if (((localIJudgeToken instanceof ClassJudgeToken)) && (!localg.p()) && (!localg.z()))
      {
        super.removeChildElement(localIJudgeToken);
        j = 1;
      }
      else if (((localIJudgeToken instanceof BooleanJudgeToken)) && (!localg.e()))
      {
        super.removeChildElement(localIJudgeToken);
        j = 1;
      }
      else if (((localIJudgeToken instanceof DateJudgeToken)) && (!localg.v()) && (!localg.w()) && (!localg.x()))
      {
        super.removeChildElement(localIJudgeToken);
        j = 1;
      }
      if (j != 0)
      {
        if (localg.m())
          addChildElement(createStringJudge());
        else if ((localg.b()) || (localg.d()))
          addChildElement(new NumberJudgeToken());
        else if (localg.j())
          addChildElement(new DecimalJudgeToken(new b(this, localg.K())));
        else if ((localg.v()) || (localg.w()) || (localg.x()))
          addChildElement(new DateJudgeToken(new a(this, localg.K())));
        else if (localg.e())
          addChildElement(new BooleanJudgeToken());
        else if ((localg.p()) || (localg.z()))
          addChildElement(new ClassJudgeToken());
        getCompareOperator().setNewType(i);
      }
    }
    if (getComparedValue() != null)
      getComparedValue().changeValueType(paramString);
  }

  public String toString()
  {
    Iterator localIterator = getMultiToken();
    StringBuffer localStringBuffer = new StringBuffer();
    while (localIterator.hasNext())
      localStringBuffer.append(localIterator.next());
    return localStringBuffer.toString();
  }

  public void addOneLeftParenthesis()
  {
    this.leftParenthesisNumber += 1;
    update();
  }

  public void deleteOneLeftParenthesis()
  {
    if (this.leftParenthesisNumber > 0)
    {
      this.leftParenthesisNumber -= 1;
      update();
    }
  }

  public void addOneRightParenthesis()
  {
    this.rightParenthesisNumber += 1;
    update();
  }

  public void deleteOneRightParenthesis()
  {
    if (this.rightParenthesisNumber > 0)
    {
      this.rightParenthesisNumber -= 1;
      update();
    }
  }

  public int getLeftParenthesisNumber()
  {
    return this.leftParenthesisNumber;
  }

  public int getRightParenthesisNumber()
  {
    return this.rightParenthesisNumber;
  }

  public int getAllLeftParenthesisNumber()
  {
    int i = this.leftParenthesisNumber;
    Iterator localIterator = getNextTests();
    while (localIterator.hasNext())
      i += ((IConditionToken)localIterator.next()).getAllLeftParenthesisNumber();
    return i;
  }

  public int getAllRightParenthesisNumber()
  {
    int i = this.rightParenthesisNumber;
    Iterator localIterator = getNextTests();
    while (localIterator.hasNext())
      i += ((IConditionToken)localIterator.next()).getAllRightParenthesisNumber();
    return i;
  }

  public void setLeftParenthesisNumber(int paramInt)
  {
    this.leftParenthesisNumber = paramInt;
  }

  public void setRightParenthesisNumber(int paramInt)
  {
    this.rightParenthesisNumber = paramInt;
  }

  public void update()
  {
    if ((getParent() instanceof IConditionToken))
      ((IConditionToken)getParent()).update();
    else
      super.update();
  }

  public boolean canPasteElement(IElement paramIElement)
  {
    return (paramIElement != null) && (((paramIElement instanceof ConditionToken)) || ((paramIElement instanceof ElementContainer))) && (getParent() != null);
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
      if ((paramIElement instanceof ConditionToken))
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
          if (!(localObject instanceof ConditionToken))
            continue;
          getParent().addChildElement((ConditionToken)localObject, i++);
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

  public boolean canGetJavaCode()
  {
    return true;
  }

  public int getOpeType()
  {
    return this.opeType;
  }

  public void setOpeType(int paramInt)
  {
    this.opeType = paramInt;
  }

  public boolean isForceOperationType()
  {
    return this.opeType > 0;
  }

  public String getForceTypeName(int paramInt)
  {
    switch (paramInt)
    {
    case 1:
      return "string";
    case 2:
      return "int";
    case 3:
      return "long";
    case 4:
      return "double";
    case 5:
      return "decimal";
    case 6:
      return "date";
    case 7:
      return "boolean";
    case 8:
      return "object";
    }
    return "";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.ConditionToken
 * JD-Core Version:    0.6.0
 */