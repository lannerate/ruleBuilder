package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.c.a;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.StaticTextToken;
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.lang.IOperatorToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ValueToken extends AbstractRuleObject
  implements IMultiEditen, IValueContainerToken
{
  private String valueType = "";
  private int leftParenthesisNumber = 0;
  private int rightParenthesisNumber = 0;
  public static final int MEMBER = 1;
  public static final int CONSTANT = 2;
  public static final int ENUM = 3;
  public static final int VARIABLE = 4;
  public static final int STATIC = 5;
  public static final int DB = 6;
  public static final int SHEET = 7;
  public static final int EXCEL = 8;
  public static final int SOAP = 9;
  public static final int XML = 10;
  public static final int TREE = 11;
  public static final int MAP = 12;
  public static final int CUSTOM = 13;
  private String argName = "";
  private transient ValueToken.TypeJudgeToken typeJudgeToken = null;
  private String note = "";
  private transient k[] popupEvents = { new A(this), new J(this), new K(this), new L(this), new M(this), new N(this), new O(this), new P(this), new Q(this), new B(this), new C(this), new D(this), new E(this), new F(this), new G(this), new H(this), new I(this) };
  private static final String[] messages = { "&setMember", "&setConstant", "&setEnum", "&setVariableMember", "&setStaticMember", "&setDBMember", "&setSheetMember", "&setExcelMember", "&setSoapField", "&setXmlMember", "&setTreeMember", "&setMapMember", "&addLeftParenthesis", "&DeleteLeftParenthesis", "&AddRightParenthesis", "&DeleteRightParenthesis" };

  public ValueToken()
  {
  }

  public ValueToken(ValueToken paramValueToken)
  {
    super(paramValueToken);
    this.valueType = paramValueToken.valueType;
    this.leftParenthesisNumber = paramValueToken.leftParenthesisNumber;
    this.rightParenthesisNumber = paramValueToken.rightParenthesisNumber;
    this.argName = paramValueToken.argName;
  }

  public ValueToken(int paramInt, String paramString1, String paramString2)
  {
    setValueType(paramString1);
    setArgName(paramString2);
    if ((getJavaType().b()) || (getJavaType().j()))
      addChildElement(new NumberOperatorToken());
    else if (getJavaType().m())
      addChildElement(new StringOperatorToken());
    else if (getJavaType().v())
      addChildElement(new DateOperatorToken());
  }

  public boolean checkOperator()
  {
    if (getOperator() == null)
      return true;
    if ((getJavaType().b()) || (getJavaType().j()))
    {
      if (!(getOperator() instanceof NumberOperatorToken))
        if (getOperator().getType() == 0)
        {
          getOperator().dispose();
          addChildElement(new NumberOperatorToken());
        }
        else
        {
          return false;
        }
    }
    else if (getJavaType().m())
    {
      if (!(getOperator() instanceof StringOperatorToken))
        if (getOperator().getType() == 0)
        {
          getOperator().dispose();
          addChildElement(new StringOperatorToken());
        }
        else
        {
          return false;
        }
    }
    else if ((getJavaType().v()) && (!(getOperator() instanceof DateOperatorToken)))
      if (getOperator().getType() == 0)
      {
        getOperator().dispose();
        addChildElement(new DateOperatorToken());
      }
      else
      {
        return false;
      }
    return true;
  }

  public ValueToken(int paramInt, String paramString1, String paramString2, IBusinessObject paramIBusinessObject)
  {
    setValueType(paramString1);
    setArgName(paramString2);
    if (d())
      addChildElement(new SheetFieldsSelectToken(this.valueType, paramIBusinessObject));
    else if (e())
      addChildElement(new SheetFunctionsSelectToken(this.valueType, paramIBusinessObject));
    else if (f())
      addChildElement(new SheetWheresSelectToken(this.valueType, paramIBusinessObject));
    else if (i())
      addChildElement(new SheetAndFieldsSelectToken(this.valueType, paramIBusinessObject));
    else if (j())
      addChildElement(new SheetFentanSelectToken(this.valueType, paramIBusinessObject));
    else if (l())
      addChildElement(new SheetAndWheresSelectToken(this.valueType, paramIBusinessObject));
    else if (k())
      addChildElement(new SheetDynamicSelectToken(this.valueType, paramIBusinessObject));
    else
      initOperator(paramString1);
  }

  public void initOperator(String paramString)
  {
    setValueType(paramString);
    if (getOperator() != null)
      getOperator().dispose();
    if ((getJavaType().b()) || (getJavaType().j()))
      addChildElement(new NumberOperatorToken());
    else if (getJavaType().m())
      addChildElement(new StringOperatorToken());
    else if (getJavaType().v())
      addChildElement(new DateOperatorToken());
  }

  k a(int paramInt)
  {
    return this.popupEvents[paramInt];
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitValueToken(this);
  }

  public void setFieldType(int paramInt)
  {
    if (paramInt == 1)
      addChildElement(new MemberToken(this.valueType));
    else if (paramInt == 2)
      addChildElement(new ConstantToken(this.valueType));
    else if (paramInt == 6)
      addChildElement(new MemberDBToken(this.valueType));
    else if (paramInt == 3)
      addChildElement(new ConstantSelectToken(this.valueType));
    else if (paramInt == 7)
      addChildElement(new MemberSheetToken(this.valueType));
    else if (paramInt == 4)
      addChildElement(new MemberVariableToken(this.valueType));
    else if (paramInt == 5)
      addChildElement(new MemberStaticToken(this.valueType));
    else if (paramInt == 8)
      addChildElement(new MemberExcelToken(this.valueType));
    else if (paramInt == 9)
      addChildElement(new MemberSoapToken(this.valueType));
    else if (paramInt == 10)
      addChildElement(new MemberXmlToken(this.valueType));
    else if (paramInt == 11)
      addChildElement(new MemberTreeToken(this.valueType));
    else if (paramInt == 12)
      addChildElement(new MemberMapToken(this.valueType));
    else if (paramInt == 13)
      addChildElement(new CustomFunctionSelectToken(this.valueType));
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

  private boolean d()
  {
    return this.valueType.equals("sheetfields");
  }

  private boolean e()
  {
    return this.valueType.equals("sheetfuncs");
  }

  private boolean f()
  {
    return this.valueType.equals("sheetwheres");
  }

  private boolean i()
  {
    return (this.valueType.equals("sheetandfields")) || (this.valueType.equals("resultandfields"));
  }

  private boolean j()
  {
    return (this.valueType.equals("sheetfentan")) || (this.valueType.equals("resultfentan"));
  }

  private boolean k()
  {
    return (this.valueType.equals("sheetdynamic")) || (this.valueType.equals("resultdynamic"));
  }

  private boolean l()
  {
    return (this.valueType.equals("sheetandwheres")) || (this.valueType.equals("resultandwheres"));
  }

  public IValueContainerToken getNextValue()
  {
    Iterator localIterator = getChildrenIterator();
    IValueContainerToken localIValueContainerToken = null;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IValueContainerToken))
        continue;
      localIValueContainerToken = (IValueContainerToken)localObject;
      break;
    }
    return localIValueContainerToken;
  }

  public void addChildElement(IElement paramIElement)
  {
    if (((paramIElement instanceof IValueToken)) && (getValueElement() != null))
      removeChildElement(getValueElement());
    else if ((paramIElement instanceof IOperatorToken))
      ((IOperatorToken)paramIElement).addJudgeTokenListener(new R(this));
    else if (((paramIElement instanceof IValueContainerToken)) && (getNextValue() != null))
      removeChildElement(getNextValue());
    super.addChildElement(paramIElement);
  }

  public IValueToken getValueElement()
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

  public boolean isEmpty()
  {
    IValueToken localIValueToken = getValueElement();
    if (localIValueToken != null)
    {
      if (getNextValue() != null)
        return false;
      return ((localIValueToken instanceof ConstantToken)) && (StringUtil.isEmpty(((ConstantToken)localIValueToken).getValue()));
    }
    return true;
  }

  public IOperatorToken getOperator()
  {
    Iterator localIterator = getChildrenIterator();
    IOperatorToken localIOperatorToken = null;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IOperatorToken))
        continue;
      localIOperatorToken = (IOperatorToken)localObject;
      break;
    }
    return localIOperatorToken;
  }

  public String getValueType()
  {
    return this.valueType;
  }

  public void setValueType(String paramString)
  {
    this.valueType = paramString;
  }

  public int getLeftParenthesisNumber()
  {
    return this.leftParenthesisNumber;
  }

  public int getRightParenthesisNumber()
  {
    return this.rightParenthesisNumber;
  }

  public void setLeftParenthesisNumber(int paramInt)
  {
    this.leftParenthesisNumber = paramInt;
  }

  public void setRightParenthesisNumber(int paramInt)
  {
    this.rightParenthesisNumber = paramInt;
  }

  public ValueToken.TypeJudgeToken getTypeJudgeToken()
  {
    if ((d()) || (e()) || (f()) || (i()) || (j()) || (l()) || (k()))
      return null;
    if (this.typeJudgeToken == null)
      a(new ValueToken.TypeJudgeToken(this));
    return this.typeJudgeToken;
  }

  public IElement deepClone()
  {
    return new ValueToken(this);
  }

  private void a(ValueToken.TypeJudgeToken paramTypeJudgeToken)
  {
    this.typeJudgeToken = paramTypeJudgeToken;
    this.typeJudgeToken.setParent(this);
  }

  public String getName()
  {
    return "ValueToken";
  }

  public g getJavaType()
  {
    return getTypeManager().a(getValueType());
  }

  public ISelectorEditen getSelector()
  {
    return getTypeJudgeToken();
  }

  public Iterator getMultiToken()
  {
    ArrayList localArrayList = new ArrayList(6);
    if (getLeftParenthesisNumber() > 0)
    {
      String str1 = "";
      for (int i = 0; i < getLeftParenthesisNumber(); i++)
        str1 = str1 + "( ";
      localArrayList.add(new StaticTextToken(str1, "parenthsis"));
    }
    boolean bool = false;
    if (getRoot() != null)
      bool = getRoot().isLocked();
    if (((!bool) || (getValueElement() == null)) && (getSelector() != null))
      localArrayList.add(getSelector());
    if (getValueElement() != null)
      localArrayList.add(getValueElement());
    if (getRightParenthesisNumber() > 0)
    {
      String str2 = "";
      for (int j = 0; j < getRightParenthesisNumber(); j++)
        str2 = str2 + ") ";
      localArrayList.add(new StaticTextToken(str2, "parenthsis"));
    }
    if ((!bool) || (getNextValue() != null))
    {
      if (getOperator() != null)
        localArrayList.add(getOperator());
      if (getNextValue() != null)
        localArrayList.add(getNextValue());
    }
    return localArrayList.iterator();
  }

  private void a(String paramString)
  {
    if (getOperator() != null)
    {
      g localg = getTypeManager().a(paramString);
      IOperatorToken localIOperatorToken = getOperator();
      int i = localIOperatorToken.getType();
      int j = 0;
      if (((getOperator() instanceof StringOperatorToken)) && (!localg.m()))
      {
        super.removeChildElement(localIOperatorToken);
        j = 1;
      }
      else if (((localIOperatorToken instanceof NumberOperatorToken)) && (!localg.b()) && (!localg.j()))
      {
        super.removeChildElement(localIOperatorToken);
        j = 1;
      }
      else if (((localIOperatorToken instanceof DateOperatorToken)) && (!localg.v()))
      {
        super.removeChildElement(localIOperatorToken);
        j = 1;
      }
      if (j != 0)
      {
        if (localg.m())
          super.addChildElement(new StringOperatorToken());
        else if ((localg.b()) || (localg.j()))
          super.addChildElement(new NumberOperatorToken());
        else if (localg.v())
          super.addChildElement(new DateOperatorToken());
        if (getOperator() != null)
        {
          getOperator().addJudgeTokenListener(new R(this));
          getOperator().setNewType(i);
        }
      }
    }
  }

  public void changeValueType(String paramString)
  {
    a(paramString);
    setValueType(paramString);
    if (getValueElement() != null)
      getValueElement().setValueType(paramString);
    if (getNextValue() != null)
      getNextValue().changeValueType(paramString);
  }

  public String getArgName()
  {
    return this.argName;
  }

  public void setArgName(String paramString)
  {
    this.argName = paramString;
  }

  public String toString()
  {
    Iterator localIterator = getMultiToken();
    StringBuffer localStringBuffer = new StringBuffer();
    while (localIterator.hasNext())
      localStringBuffer.append(localIterator.next());
    return localStringBuffer.toString();
  }

  public String getNote()
  {
    if (this.note.length() > 0)
      return this.note;
    return super.getNote();
  }

  public void setNote(String paramString)
  {
    this.note = paramString;
  }

  public boolean canPasteObject(Object paramObject)
  {
    return ((paramObject instanceof ConstantEnum)) || ((paramObject instanceof IBusinessObject)) || ((paramObject instanceof String)) || ((paramObject instanceof ValueToken));
  }

  public boolean pasteBusinessObject(Object paramObject)
  {
    if ((paramObject instanceof ConstantEnum))
    {
      h();
      setFieldType(3);
      if (((ConstantSelectToken)getValueElement()).acceptBusinessObject(paramObject))
        ((ConstantSelectToken)getValueElement()).setMemberElement((ConstantEnum)paramObject);
      g();
      update();
      return true;
    }
    if ((paramObject instanceof IBusinessObject))
    {
      h();
      setFieldType(1);
      if (((MemberToken)getValueElement()).acceptBusinessObject(paramObject))
        ((MemberToken)getValueElement()).setMemberElement((IBusinessObject)paramObject);
      g();
      update();
      return true;
    }
    if ((paramObject instanceof String))
    {
      h();
      setFieldType(2);
      ((ConstantToken)getValueElement()).setValue((String)paramObject);
      g();
      update();
      return true;
    }
    if ((paramObject instanceof ValueToken))
    {
      h();
      ValueToken localValueToken = (ValueToken)paramObject;
      if (this.valueType.length() == 0)
        this.valueType = localValueToken.valueType;
      this.leftParenthesisNumber = localValueToken.leftParenthesisNumber;
      this.rightParenthesisNumber = localValueToken.rightParenthesisNumber;
      setDisplayName(localValueToken.getDisplayName());
      clearAllChildren();
      for (int i = 0; i < localValueToken.getChildrenCount(); i++)
        addChildElement(((IElement)localValueToken.a().get(i)).deepClone());
      a(this.valueType);
      if (getValueElement() != null)
        getValueElement().setValueType(this.valueType);
      if (getNextValue() != null)
        getNextValue().changeValueType(this.valueType);
      g();
      update();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.ValueToken
 * JD-Core Version:    0.6.0
 */