package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.b;
import com.flagleader.builder.b.p;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.rlm.value.ConstantSelectToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionElementValue;
import com.flagleader.repository.tree.DecisionRelateAction;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.l;
import java.util.HashMap;
import java.util.List;
import org.agilemore.agilegrid.J;
import org.agilemore.agilegrid.X;
import org.agilemore.agilegrid.e;

public class N extends X
{
  public N(o paramo, e parame)
  {
    super(parame, true);
  }

  public J a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (o.c(this.a))
      return null;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (new b(o.b(this.a).getShell(), o.b(this.a), o.a(this.a).getConditions()).open() == 0))
      this.a.update();
    Object localObject1;
    if ((paramInt1 == 0) && (paramInt2 >= o.a(this.a).getConditionNum()) && (paramInt2 < o.a(this.a).getConditionNum() + o.a(this.a).getValueNum()))
    {
      localObject1 = new com.flagleader.builder.b.d(o.b(this.a).getShell(), o.b(this.a), o.a(this.a).getDecisionElement(paramInt2 - o.a(this.a).getConditionNum() + 1).getContainer());
      if (((com.flagleader.builder.b.d)localObject1).open() == 0)
        this.a.update();
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramInt1 > 0) && (paramInt2 >= o.a(this.a).getConditionNum()) && (paramInt2 < o.a(this.a).getConditionNum() + o.a(this.a).getValueNum()))
    {
      localObject1 = (DecisionElementValue)o.e(this.a).get(new G(paramInt1, paramInt2));
      if ((localObject1 != null) && (((DecisionElementValue)localObject1).isTextValue()))
        return new O(this, this.b, (DecisionElementValue)localObject1);
      if ((localObject1 != null) && (((DecisionElementValue)localObject1).isComboValue()))
      {
        localObject2 = ((DecisionElementValue)localObject1).getComboEnums();
        localObject3 = new P(this, this.b, 8, (List)localObject2, (DecisionElementValue)localObject1);
        if (localObject2 != null)
        {
          localObject4 = new String[((List)localObject2).size()];
          for (int i = 0; i < ((List)localObject2).size(); i++)
            localObject4[i] = ((ConstantEnum)((List)localObject2).get(i)).getShowDisplayName();
          ((org.agilemore.agilegrid.a.d)localObject3).a(localObject4);
        }
        return localObject3;
      }
    }
    if ((!o.c(this.a)) && (paramInt1 > 0))
      if (paramInt2 >= o.a(this.a).getConditionNum())
      {
        if (paramInt2 < o.a(this.a).getConditionNum() + o.a(this.a).getValueNum())
        {
          localObject1 = new com.flagleader.builder.b.d(o.b(this.a).getShell(), o.b(this.a), (DecisionElementValue)o.e(this.a).get(new G(paramInt1, paramInt2)));
          if (((com.flagleader.builder.b.d)localObject1).open() == 0)
            this.a.update();
        }
        else
        {
          localObject1 = new p(o.b(this.a).getShell(), o.b(this.a), ((DecisionRelateAction)o.e(this.a).get(new G(paramInt1, paramInt2))).getThenActions());
          if (((p)localObject1).open() == 0)
            this.a.update();
        }
      }
      else
      {
        localObject1 = (ILangToken)o.e(this.a).get(new G(paramInt1, paramInt2));
        if ((localObject1 != null) && ((localObject1 instanceof IConditionToken)))
        {
          localObject2 = ((IConditionToken)localObject1).getConstantValue();
          if (localObject2 != null)
            return new Q(this, this.b, (ConstantToken)localObject2);
          localObject3 = ((IConditionToken)localObject1).getComboValue();
          if (localObject3 != null)
          {
            localObject4 = ((IConditionToken)localObject1).getComboEnums();
            R localR = new R(this, this.b, 8, (List)localObject4, (ILangToken)localObject1);
            if (localObject4 != null)
            {
              String[] arrayOfString = new String[((List)localObject4).size()];
              for (int j = 0; j < ((List)localObject4).size(); j++)
                arrayOfString[j] = ((ConstantEnum)((List)localObject4).get(j)).getShowDisplayName();
              localR.a(arrayOfString);
            }
            return localR;
          }
        }
        if (paramInt2 == 0)
        {
          if (new b(o.b(this.a).getShell(), o.b(this.a), o.a(this.a).getConditions()).open() == 0)
            this.a.update();
        }
        else
        {
          localObject2 = (l)this.a.e().get(paramInt1 - 1);
          if ((localObject2 != null) && (((l)localObject2).a().size() > paramInt2 - 1) && (new b(o.b(this.a).getShell(), o.b(this.a), o.a(this.a).getRelateCondition((IConditionToken)((l)localObject2).a().get(paramInt2 - 1), paramInt2)).open() == 0))
            this.a.update();
        }
      }
    return (J)(J)(J)(J)null;
  }

  public void a(J paramJ, org.agilemore.agilegrid.G paramG)
  {
    Object localObject1;
    Object localObject2;
    if ((paramG.c > 0) && (paramG.d >= o.a(this.a).getConditionNum()))
    {
      localObject1 = (DecisionElementValue)o.e(this.a).get(new G(paramG.c, paramG.d));
      if ((localObject1 != null) && (((DecisionElementValue)localObject1).isTextValue()))
      {
        localObject2 = ((DecisionElementValue)localObject1).getConstantValue();
        paramJ.c(localObject2);
        return;
      }
      if ((localObject1 != null) && (((DecisionElementValue)localObject1).isComboValue()))
      {
        localObject2 = ((DecisionElementValue)localObject1).getText();
        paramJ.c(localObject2);
        return;
      }
    }
    if (paramG.c > 0)
      if (paramG.d >= o.a(this.a).getConditionNum())
      {
        paramJ.c(o.e(this.a).get(new G(paramG.c, paramG.d)));
      }
      else
      {
        localObject1 = (ILangToken)o.e(this.a).get(new G(paramG.c, paramG.d));
        if ((localObject1 != null) && ((localObject1 instanceof IConditionToken)))
        {
          localObject2 = ((IConditionToken)localObject1).getConstantValue();
          if (localObject2 != null)
          {
            localObject3 = ((ConstantToken)localObject2).getText();
            paramJ.c(localObject3);
            return;
          }
          Object localObject3 = ((IConditionToken)localObject1).getComboValue();
          if (localObject3 != null)
          {
            String str = ((ConstantSelectToken)localObject3).getShowDisplayName();
            paramJ.c(str);
            return;
          }
        }
        if (paramG.d == 0)
        {
          paramJ.c(o.a(this.a).getConditions());
          return;
        }
        localObject2 = (l)this.a.e().get(paramG.c - 1);
        if ((localObject2 != null) && (((l)localObject2).a().size() > paramG.d - 1))
          paramJ.c(o.a(this.a).getRelateCondition((IConditionToken)((l)localObject2).a().get(paramG.d - 1), paramG.d));
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.N
 * JD-Core Version:    0.6.0
 */