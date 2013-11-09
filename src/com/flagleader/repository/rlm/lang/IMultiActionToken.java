package com.flagleader.repository.rlm.lang;

import com.flagleader.repository.rom.IVariableObject;
import java.util.Iterator;

public abstract interface IMultiActionToken extends ILangToken
{
  public static final int THEN = 0;
  public static final int RULEINIT = 1;
  public static final int SETINIT = 2;
  public static final int ELSE = 3;
  public static final int CATCH = 4;
  public static final int BLOCK = 5;
  public static final int FIRST = 6;

  public abstract Iterator getActions();

  public abstract int getType();

  public abstract void setType(int paramInt);

  public abstract boolean addVariableDebug(IVariableObject paramIVariableObject);

  public abstract boolean clearDebug();

  public abstract boolean addVariableInit(IVariableObject paramIVariableObject);

  public abstract boolean hasTwoReturnToken();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.lang.IMultiActionToken
 * JD-Core Version:    0.6.0
 */