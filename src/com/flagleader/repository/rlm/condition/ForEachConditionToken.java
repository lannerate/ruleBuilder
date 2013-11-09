package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.l;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.StaticTextToken;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachConditionToken extends AbstractRuleObject
  implements ILineEditen, IMultiEditen, IStatementToken
{
  ForEachConditionToken.ExcuteTypeSelector a;
  public static final int foreachadd = 0;
  public static final int foreachminus = 1;
  public static final int foreacharray = 2;
  public static final int foreachlist = 3;
  public static final int foreachmap = 3;
  private static final String[] messages = { "&foreachadd", "&foreachminus", "&foreacharray", "&foreachlist", "&foreachmap" };
  private int returnType = 0;
  private transient l[] popupMessages = null;

  public ForEachConditionToken()
  {
  }

  public ForEachConditionToken(ForEachConditionToken paramForEachConditionToken)
  {
    super(paramForEachConditionToken);
    this.returnType = paramForEachConditionToken.returnType;
  }

  protected void d()
  {
    this.popupMessages = new l[5];
    for (int i = 0; i < 5; i++)
    {
      String str = getLocalString(messages[i].substring(1) + ".edit", messages[i].substring(1));
      this.popupMessages[i] = new l(str, new i(this, i), null);
    }
  }

  public ForEachConditionToken init()
  {
    a().clear();
    FieldToken localFieldToken;
    ValueToken localValueToken;
    if ((this.returnType == 0) || (this.returnType == 1))
    {
      localFieldToken = new FieldToken();
      addChildElement(localFieldToken);
      localValueToken = new ValueToken(2, "int", "first");
      localValueToken.setFieldType(2);
      addChildElement(localValueToken);
      localValueToken = new ValueToken(2, "int", "last");
      localValueToken.setFieldType(2);
      addChildElement(localValueToken);
    }
    else if (this.returnType == 2)
    {
      localFieldToken = new FieldToken();
      addChildElement(localFieldToken);
      localValueToken = new ValueToken(2, "Object[]", "array");
      localValueToken.setFieldType(1);
      addChildElement(localValueToken);
    }
    else if (this.returnType == 3)
    {
      localFieldToken = new FieldToken();
      addChildElement(localFieldToken);
      localValueToken = new ValueToken(2, "list", "list");
      localValueToken.setFieldType(1);
      addChildElement(localValueToken);
    }
    else if (this.returnType == 3)
    {
      localFieldToken = new FieldToken();
      addChildElement(localFieldToken);
      localFieldToken = new FieldToken();
      addChildElement(localFieldToken);
      localValueToken = new ValueToken(2, "map", "map");
      localValueToken.setFieldType(1);
      addChildElement(localValueToken);
    }
    return this;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitForEachConditionToken(this);
  }

  public IElement deepClone()
  {
    return new ForEachConditionToken(this);
  }

  public String getName()
  {
    return "ForEachConditionToken";
  }

  public int getReturnType()
  {
    return this.returnType;
  }

  public void changeReturnType(int paramInt)
  {
    this.returnType = paramInt;
  }

  public void setReturnType(int paramInt)
  {
    this.returnType = paramInt;
  }

  public l[] getLeftPopupMenus()
  {
    if (this.popupMessages == null)
      d();
    return this.popupMessages;
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof FieldToken)) || ((paramIElement instanceof IValueContainerToken));
  }

  public FieldToken getFirstToken()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof FieldToken))
        return (FieldToken)localObject;
    }
    return null;
  }

  public FieldToken getSecondToken()
  {
    for (int i = getChildrenCount() - 1; i >= 0; i--)
    {
      Object localObject = a().get(i);
      if ((localObject instanceof FieldToken))
        return (FieldToken)localObject;
    }
    return null;
  }

  public IValueContainerToken getRuleVersionToken(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof ValueToken)) && (((ValueToken)localObject).getArgName().equalsIgnoreCase(paramString)))
        return (IValueContainerToken)localObject;
    }
    return null;
  }

  private ForEachConditionToken.ExcuteTypeSelector e()
  {
    if (this.a == null)
      this.a = new ForEachConditionToken.ExcuteTypeSelector(this);
    return this.a;
  }

  public Iterator getMultiToken()
  {
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(e());
    localArrayList.add(getFirstToken());
    if (this.returnType == 0)
    {
      localArrayList.add(new StaticTextToken(getLocalString("foreachadd2.edit", ",Version"), "rulepackage"));
      localArrayList.add(getRuleVersionToken("first"));
      localArrayList.add(new StaticTextToken(getLocalString("foreachadd3.edit", ",Version"), "rulepackage"));
      localArrayList.add(getRuleVersionToken("last"));
    }
    else if (this.returnType == 1)
    {
      localArrayList.add(new StaticTextToken(getLocalString("foreachminus2.edit", ",Version"), "rulepackage"));
      localArrayList.add(getRuleVersionToken("first"));
      localArrayList.add(new StaticTextToken(getLocalString("foreachminus3.edit", ",Version"), "rulepackage"));
      localArrayList.add(getRuleVersionToken("last"));
    }
    else if (this.returnType == 2)
    {
      localArrayList.add(new StaticTextToken(getLocalString("foreacharray2.edit", ",Version"), "rulepackage"));
      localArrayList.add(getRuleVersionToken("array"));
    }
    else if (this.returnType == 3)
    {
      localArrayList.add(new StaticTextToken(getLocalString("foreachlist2.edit", ",Version"), "rulepackage"));
      localArrayList.add(getRuleVersionToken("list"));
    }
    else if (this.returnType == 3)
    {
      localArrayList.add(new StaticTextToken(getLocalString("foreachmap2.edit", ",Version"), "rulepackage"));
      localArrayList.add(getSecondToken());
      localArrayList.add(new StaticTextToken(getLocalString("foreachmap3.edit", ",Version"), "rulepackage"));
      localArrayList.add(getRuleVersionToken("map"));
    }
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

  public boolean canPasteElement(IElement paramIElement)
  {
    return (paramIElement != null) && (((paramIElement instanceof ForEachConditionToken)) || ((paramIElement instanceof ElementContainer)) || ((paramIElement instanceof IBusinessObject))) && (getParent() != null);
  }

  public boolean paste(IElement paramIElement)
  {
    return pasteElement(paramIElement);
  }

  public boolean pasteElement(IElement paramIElement)
  {
    if (canPasteElement(paramIElement))
    {
      h();
      if ((paramIElement instanceof ForEachConditionToken))
      {
        a().clear();
        replaceAllChildren(((ForEachConditionToken)paramIElement).a());
      }
      else if ((paramIElement instanceof ElementContainer))
      {
        Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (!(localObject instanceof ConditionToken))
            continue;
          a().clear();
          replaceAllChildren(((ForEachConditionToken)localObject).a());
        }
      }
      else if (((paramIElement instanceof IBusinessObject)) && ((((IBusinessObject)paramIElement).getJavaType().b()) || (((IBusinessObject)paramIElement).getJavaType().G()) || (((IBusinessObject)paramIElement).getJavaType().j()) || (((IBusinessObject)paramIElement).getJavaType().m()) || (((IBusinessObject)paramIElement).getJavaType().e())))
      {
        getFirstToken().setMemberElement((IBusinessObject)paramIElement);
      }
      g();
      return true;
    }
    return false;
  }

  public boolean canCopy()
  {
    return false;
  }

  public boolean canCut()
  {
    return false;
  }

  public IElement copyElement()
  {
    return null;
  }

  public IElement cutElement()
  {
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.ForEachConditionToken
 * JD-Core Version:    0.6.0
 */