package com.flagleader.repository.rlm.lang;

import com.flagleader.repository.rlm.editen.IModifierEditen;
import com.flagleader.repository.rlm.value.ConstantSelectToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rom.ConstantEnum;
import java.util.Iterator;
import java.util.List;

public abstract interface IConditionToken extends ILangToken
{
  public static final int FORCENONE = 0;
  public static final int FORCESTRING = 1;
  public static final int FORCEINT = 2;
  public static final int FORCELONG = 3;
  public static final int FORCEDOUBLE = 4;
  public static final int FORCEDECIMAL = 5;
  public static final int FORCEDATE = 6;
  public static final int FORCEBOOLEAN = 7;
  public static final int FORCECLASS = 8;

  public abstract ILogicalToken getLogicalOperator();

  public abstract IValueToken getFirstValue();

  public abstract IJudgeToken getCompareOperator();

  public abstract IValueContainerToken getComparedValue();

  public abstract Iterator getNextTests();

  public abstract boolean isFirstCondition();

  public abstract IModifierEditen getDisposeModifier();

  public abstract IMultiConditionToken getConditionContainer();

  public abstract int getLeftParenthesisNumber();

  public abstract int getRightParenthesisNumber();

  public abstract int getAllLeftParenthesisNumber();

  public abstract int getAllRightParenthesisNumber();

  public abstract void addOneLeftParenthesis();

  public abstract void deleteOneLeftParenthesis();

  public abstract void addOneRightParenthesis();

  public abstract void deleteOneRightParenthesis();

  public abstract String getText();

  public abstract ConstantToken getConstantValue();

  public abstract ConstantSelectToken getComboValue();

  public abstract void setValue(ConstantEnum paramConstantEnum);

  public abstract List getComboEnums();

  public abstract int getOpeType();

  public abstract void setOpeType(int paramInt);

  public abstract boolean isForceOperationType();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.lang.IConditionToken
 * JD-Core Version:    0.6.0
 */