package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.b;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.rlm.value.ConstantSelectToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.DecisionValue;
import com.flagleader.repository.tree.l;
import java.util.HashMap;
import java.util.List;
import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.J;
import org.agilemore.agilegrid.X;
import org.agilemore.agilegrid.e;

public class aC extends X
{
  public aC(af paramaf, e parame)
  {
    super(parame, true);
  }

  public J a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (af.c(this.a))
      return null;
    Object localObject1;
    if (paramInt1 == 0)
    {
      if (paramInt2 == 0)
      {
        localObject1 = new com.flagleader.builder.b.d(af.b(this.a).getShell(), af.b(this.a), af.a(this.a).getContainer());
        if (((com.flagleader.builder.b.d)localObject1).open() == 0)
          this.a.update();
      }
      if ((paramInt2 >= af.a(this.a).getConditionNum()) && (new b(af.b(this.a).getShell(), af.b(this.a), af.a(this.a).getFirstConditions()).open() == 0))
        this.a.update();
    }
    else
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (paramInt1 == 1)
      {
        if (paramInt2 == 0)
        {
          if (new b(af.b(this.a).getShell(), af.b(this.a), af.a(this.a).getSecondConditions()).open() == 0)
            this.a.update();
        }
        else
        {
          localObject1 = (ILangToken)af.e(this.a).get(new av(paramInt1, paramInt2));
          if ((localObject1 != null) && ((localObject1 instanceof IConditionToken)))
          {
            localObject2 = ((IConditionToken)localObject1).getConstantValue();
            if (localObject2 != null)
              return new aD(this, this.b, (ConstantToken)localObject2);
            localObject3 = ((IConditionToken)localObject1).getComboValue();
            if (localObject3 != null)
            {
              localObject4 = ((IConditionToken)localObject1).getComboEnums();
              aE localaE = new aE(this, this.b, 8, (List)localObject4, (ILangToken)localObject1);
              if (localObject4 != null)
              {
                String[] arrayOfString = new String[((List)localObject4).size()];
                for (int j = 0; j < ((List)localObject4).size(); j++)
                  arrayOfString[j] = ((ConstantEnum)((List)localObject4).get(j)).getShowDisplayName();
                localaE.a(arrayOfString);
              }
              return localaE;
            }
          }
        }
      }
      else if ((paramInt1 > 1) && (paramInt2 >= af.a(this.a).getConditionNum()))
      {
        localObject1 = (DecisionValue)af.e(this.a).get(new av(paramInt1, paramInt2));
        if ((localObject1 != null) && (((DecisionValue)localObject1).isTextValue()))
          return new aF(this, this.b, (DecisionValue)localObject1);
        if ((localObject1 != null) && (((DecisionValue)localObject1).isComboValue()))
        {
          localObject2 = ((DecisionValue)localObject1).getComboEnums();
          localObject3 = new aG(this, this.b, 8, (List)localObject2, (DecisionValue)localObject1);
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
      else if ((!af.c(this.a)) && (paramInt1 > 1))
      {
        if (paramInt2 >= af.a(this.a).getConditionNum())
        {
          localObject1 = new com.flagleader.builder.b.d(af.b(this.a).getShell(), af.b(this.a), (DecisionValue)af.e(this.a).get(new av(paramInt1, paramInt2)));
          if (((com.flagleader.builder.b.d)localObject1).open() == 0)
            this.a.update();
        }
        else
        {
          localObject1 = (ILangToken)af.e(this.a).get(new av(paramInt1, paramInt2));
          if ((localObject1 != null) && ((localObject1 instanceof IConditionToken)))
          {
            localObject2 = ((IConditionToken)localObject1).getConstantValue();
            if (localObject2 != null)
              return new aH(this, this.b, (ConstantToken)localObject2);
          }
          if (paramInt2 == 0)
          {
            if (new b(af.b(this.a).getShell(), af.b(this.a), af.a(this.a).getSecondConditions()).open() == 0)
              this.a.update();
          }
          else
          {
            localObject2 = (l)this.a.e().get(paramInt1 - 2);
            if ((localObject2 != null) && (((l)localObject2).a().size() > paramInt2 - 1) && (new b(af.b(this.a).getShell(), af.b(this.a), af.a(this.a).getRelateCondition((IConditionToken)((l)localObject2).a().get(paramInt2 - 1), paramInt2)).open() == 0))
              this.a.update();
          }
        }
      }
    }
    return (J)(J)(J)(J)null;
  }

  public void a(J paramJ, G paramG)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramG.c == 1)
    {
      localObject1 = (ILangToken)af.e(this.a).get(new av(paramG.c, paramG.d));
      if ((localObject1 != null) && ((localObject1 instanceof IConditionToken)))
      {
        localObject2 = ((IConditionToken)localObject1).getConstantValue();
        if (localObject2 != null)
        {
          localObject3 = ((ConstantToken)localObject2).getText();
          paramJ.c(localObject3);
          return;
        }
        localObject3 = ((IConditionToken)localObject1).getComboValue();
        if (localObject3 != null)
        {
          String str = ((ConstantSelectToken)localObject3).getShowDisplayName();
          paramJ.c(str);
          return;
        }
      }
    }
    if ((paramG.c > 1) && (paramG.d >= af.a(this.a).getConditionNum()))
    {
      localObject1 = (DecisionValue)af.e(this.a).get(new av(paramG.c, paramG.d));
      if ((localObject1 != null) && (((DecisionValue)localObject1).isTextValue()))
      {
        localObject2 = ((DecisionValue)localObject1).getConstantValue();
        paramJ.c(localObject2);
        return;
      }
    }
    if (paramG.c > 1)
      if (paramG.d >= af.a(this.a).getConditionNum())
      {
        paramJ.c(af.e(this.a).get(new av(paramG.c, paramG.d)));
      }
      else
      {
        localObject1 = (ILangToken)af.e(this.a).get(new av(paramG.c, paramG.d));
        if ((localObject1 != null) && ((localObject1 instanceof IConditionToken)))
        {
          localObject2 = ((IConditionToken)localObject1).getConstantValue();
          if (localObject2 != null)
          {
            localObject3 = ((ConstantToken)localObject2).getText();
            paramJ.c(localObject3);
            return;
          }
        }
        if (paramG.d == 0)
        {
          paramJ.c(af.a(this.a).getSecondConditions());
          return;
        }
        localObject2 = (l)this.a.e().get(paramG.c - 2);
        if ((localObject2 != null) && (((l)localObject2).a().size() > paramG.d - 1))
          paramJ.c(af.a(this.a).getRelateCondition((IConditionToken)((l)localObject2).a().get(paramG.d - 1), paramG.d));
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aC
 * JD-Core Version:    0.6.0
 */