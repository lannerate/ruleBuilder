package com.flagleader.repository.rlm;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.c.m;
import com.flagleader.repository.k;
import com.flagleader.repository.l;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.util.exception.UnsupportOperationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class JudgeToken extends AbstractRuleObject
  implements ISelectorEditen
{
  protected int a = -1;
  public static final int MORETYPE = -2;
  private transient List judgeTokenListeners = new ArrayList();
  public static final int NOTYPE = -1;
  protected static final String NOTYPEMSG = "&noType";
  private transient l[] popupMessages = null;
  protected transient boolean b = false;

  public JudgeToken()
  {
  }

  public JudgeToken(JudgeToken paramJudgeToken)
  {
    super(paramJudgeToken);
    this.a = paramJudgeToken.a;
  }

  public JudgeToken(int paramInt)
  {
    this.a = paramInt;
  }

  public int getType()
  {
    return this.a;
  }

  public void setType(int paramInt)
  {
    if (this.a != paramInt)
    {
      setNewType(paramInt);
      a(true);
    }
    else
    {
      a(false);
    }
  }

  public void setNewType(int paramInt)
  {
    if (this.a != paramInt)
      if (paramInt < d())
        this.a = paramInt;
      else
        this.a = 0;
  }

  protected int d()
  {
    return getCount();
  }

  public void setType(String paramString)
  {
    try
    {
      setType(Integer.parseInt(paramString));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
  }

  public String getTypeName(int paramInt)
  {
    String str = "&noType";
    str = a(paramInt);
    if ((str != null) && (str.length() > 0) && (str.charAt(0) == '&'))
      str = getLocalString(str.substring(1) + ".edit", str.substring(1));
    return str;
  }

  protected void e()
  {
    this.popupMessages = new l[getCount()];
    for (int i = 0; i < getCount(); i++)
    {
      k localk = b(i);
      this.popupMessages[i] = new l(localk.d().trim(), localk, null);
    }
    setInited(true);
  }

  public abstract boolean acceptType(g paramg);

  protected abstract String a(int paramInt);

  protected abstract k b(int paramInt);

  public abstract int getCount();

  public l[] getLeftPopupMenus()
  {
    if (!isInited())
      e();
    return this.popupMessages;
  }

  public boolean hasLeftPopupMenus()
  {
    return true;
  }

  public void addJudgeTokenListener(m paramm)
  {
    this.judgeTokenListeners.add(paramm);
  }

  public List getListeners()
  {
    if (this.judgeTokenListeners == null)
      this.judgeTokenListeners = new ArrayList();
    return this.judgeTokenListeners;
  }

  public void removeJudgeTokenLister(m paramm)
  {
    this.judgeTokenListeners.remove(paramm);
  }

  protected void a(boolean paramBoolean)
  {
    Iterator localIterator = this.judgeTokenListeners.iterator();
    while (localIterator.hasNext())
      ((m)localIterator.next()).a(this, paramBoolean);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitJudgeToken(this);
  }

  public boolean isInited()
  {
    return this.b;
  }

  public void setInited(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public IElement deepClone()
  {
    throw new UnsupportOperationException();
  }

  public String getNote()
  {
    return getLocalString(getName() + ".note", "");
  }

  public String getDisplayName()
  {
    return getTypeName(getType());
  }

  public String getRlmStr()
  {
    throw new UnsupportOperationException();
  }

  public boolean canEdit()
  {
    return false;
  }

  public String getHint()
  {
    throw new UnsupportOperationException();
  }

  public String getText()
  {
    throw new UnsupportOperationException();
  }

  public boolean hasHint()
  {
    return false;
  }

  public void setText(String paramString)
  {
    throw new UnsupportOperationException();
  }

  public boolean checkValue(String paramString)
  {
    return false;
  }

  public String getColorType()
  {
    return "judge";
  }

  public IElement getBusinessObject()
  {
    return null;
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    return false;
  }

  public boolean pasteBusinessObject(Object paramObject)
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.JudgeToken
 * JD-Core Version:    0.6.0
 */