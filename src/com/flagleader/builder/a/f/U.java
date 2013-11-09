package com.flagleader.builder.a.f;

import com.flagleader.repository.IElement;
import com.flagleader.repository.e.m;
import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionRelateAction;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.l;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.agilemore.agilegrid.c;

public class U extends c
{
  private Random d = new Random();

  public U(o paramo)
  {
  }

  public Object a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (paramInt2 < o.a(this.a).getConditionNum())
        return o.a(this.a).getFirstMember(paramInt2 + 1);
      if ((paramInt2 < o.a(this.a).getConditionNum() + o.a(this.a).getValueNum()) && (o.a(this.a).getDecisionElement(paramInt2 - o.a(this.a).getConditionNum() + 1) != null))
        return o.a(this.a).getDecisionElement(paramInt2 - o.a(this.a).getConditionNum() + 1).getShowDisplayName();
      return "";
    }
    G localG = new G(paramInt1, paramInt2);
    Object localObject1 = (IElement)o.e(this.a).get(localG);
    Object localObject2;
    if ((localObject1 == null) && (paramInt1 > 0) && (this.a.e().size() > paramInt1 - 1))
    {
      localObject2 = (l)this.a.e().get(paramInt1 - 1);
      if (paramInt2 < o.a(this.a).getConditionNum())
      {
        if (((l)localObject2).a().size() > paramInt2)
          localObject1 = (ILangToken)((l)localObject2).a().get(paramInt2);
      }
      else if ((o.a(this.a).getValueNum() > 0) && (paramInt2 < o.a(this.a).getConditionNum() + o.a(this.a).getValueNum()))
      {
        if (o.a(this.a).getDecisionElement(paramInt2 - o.a(this.a).getConditionNum() + 1) != null)
          localObject1 = o.a(this.a).getDecisionValue(((l)localObject2).a(), o.a(this.a).getDecisionElement(paramInt2 - o.a(this.a).getConditionNum() + 1).getMemberElement());
      }
      else if (paramInt2 < o.a(this.a).getConditionNum() + o.a(this.a).getValueNum() + 1)
        localObject1 = o.a(this.a).getDecisionAction(((l)localObject2).a());
      if (localObject1 != null)
        o.e(this.a).put(localG, localObject1);
    }
    if (localObject1 != null)
    {
      if ((localObject1 instanceof IConditionToken))
        return o.a(this.a).parseShortName(localObject1.toString(), o.a(this.a).getFirstMember(paramInt2 + 1));
      if ((localObject1 instanceof DecisionElementValue))
        return ((DecisionElementValue)localObject1).getValue();
      if ((localObject1 instanceof DecisionRelateAction))
      {
        localObject2 = ((DecisionRelateAction)localObject1).getThenActions().getText();
        if (((String)localObject2).endsWith(m.q))
          return ((String)localObject2).substring(0, ((String)localObject2).length() - m.q.length());
        return localObject2;
      }
    }
    return "";
  }

  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.U
 * JD-Core Version:    0.6.0
 */