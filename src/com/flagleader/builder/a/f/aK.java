package com.flagleader.builder.a.f;

import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.DecisionValue;
import com.flagleader.repository.tree.l;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.agilemore.agilegrid.c;

public class aK extends c
{
  private Random d = new Random();

  public aK(af paramaf)
  {
  }

  public Object a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (paramInt2 < af.a(this.a).getConditionNum())
      {
        if (af.a(this.a).getMemberElement() != null)
          return af.a(this.a).getMemberElement().getDisplayName();
        return "";
      }
      if (paramInt2 < af.a(this.a).getConditionNum() + af.a(this.a).getMaxX())
        return af.a(this.a).getSecondMember();
      return "";
    }
    Object localObject3;
    if (paramInt1 == 1)
    {
      if (paramInt2 < af.a(this.a).getConditionNum())
        return af.a(this.a).getFirstMember(paramInt2 + 1);
      localObject1 = af.a(this.a).getFirstConditions().getCondition(paramInt2 - af.a(this.a).getConditionNum());
      if (localObject1 != null)
      {
        localObject2 = new av(paramInt1, paramInt2);
        localObject3 = (ILangToken)af.e(this.a).get(localObject2);
        if (localObject3 == null)
          af.e(this.a).put(localObject2, localObject1);
        return af.a(this.a).parseShortName(af.a(this.a).getFirstConditions().getCondition(paramInt2 - af.a(this.a).getConditionNum()).toString(), af.a(this.a).getSecondMember());
      }
      return "";
    }
    Object localObject1 = new av(paramInt1, paramInt2);
    Object localObject2 = (ILangToken)af.e(this.a).get(localObject1);
    if ((localObject2 == null) && (paramInt1 > 1) && (this.a.e().size() > paramInt1 - 2))
    {
      localObject3 = (l)this.a.e().get(paramInt1 - 2);
      if (paramInt2 < af.a(this.a).getConditionNum())
      {
        if (((l)localObject3).a().size() > paramInt2)
          localObject2 = (ILangToken)((l)localObject3).a().get(paramInt2);
      }
      else if (paramInt2 < af.a(this.a).getConditionNum() + af.a(this.a).getMaxX())
        localObject2 = af.a(this.a).getDecisionValue(((l)localObject3).a(), af.a(this.a).getFirstConditions().getCondition(paramInt2 - af.a(this.a).getConditionNum()));
      if (localObject2 != null)
        af.e(this.a).put(localObject1, localObject2);
    }
    if (localObject2 != null)
    {
      if ((localObject2 instanceof IConditionToken))
        return af.a(this.a).parseShortName(localObject2.toString(), af.a(this.a).getFirstMember(paramInt2 + 1));
      if ((localObject2 instanceof DecisionValue))
        return ((DecisionValue)localObject2).getValue();
    }
    return "";
  }

  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aK
 * JD-Core Version:    0.6.0
 */