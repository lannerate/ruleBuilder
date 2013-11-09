package com.flagleader.builder.actions.i;

import com.flagleader.builder.dialogs.f.c;
import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rlm.AbstractElementToken;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.value.ConstantSelectToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.SheetFieldMapping;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.Envionment;

class k
  implements ChildAcceptor
{
  k(j paramj, c paramc)
  {
  }

  public boolean accept(Object paramObject)
  {
    String str = this.b.a();
    boolean bool1 = this.b.b();
    boolean bool2 = this.b.c();
    if (this.b.d())
    {
      if ((paramObject instanceof ConstantToken))
        return j.a(this.a, ((ConstantToken)paramObject).getValue(), str, bool1, bool2);
    }
    else
    {
      Object localObject;
      if (this.b.g())
      {
        if ((paramObject instanceof ConstantSelectToken))
        {
          localObject = ((ConstantSelectToken)paramObject).getConstantMember();
          return j.a(this.a, ((ConstantEnum)localObject).getValue(), str, bool1, bool2);
        }
      }
      else if (this.b.i())
      {
        if ((paramObject instanceof ILineEditen))
          return j.a(this.a, ((ILineEditen)paramObject).getJavaCode(), str, bool1, bool2);
      }
      else if (this.b.f())
      {
        if ((paramObject instanceof AbstractElementToken))
        {
          localObject = ((AbstractElementToken)paramObject).getMemberElement();
          if ((localObject instanceof IBusinessObject))
            return j.a(this.a, ((IBusinessObject)localObject).getDisplayName(), str, bool1, bool2);
        }
        else if ((paramObject instanceof SheetFieldMapping))
        {
          localObject = ((SheetFieldMapping)paramObject).getMemberElement();
          if ((localObject instanceof IBusinessObject))
            return j.a(this.a, ((IBusinessObject)localObject).getDisplayName(), str, bool1, bool2);
          localObject = ((SheetFieldMapping)paramObject).getMappingField();
          if ((localObject instanceof IBusinessObject))
            return j.a(this.a, ((IBusinessObject)localObject).getDisplayName(), str, bool1, bool2);
        }
      }
      else if (this.b.e())
      {
        if ((paramObject instanceof AbstractElementToken))
        {
          localObject = ((AbstractElementToken)paramObject).getMemberElement();
          if ((localObject instanceof IBusinessObject))
            return j.a(this.a, ((IBusinessObject)localObject).getValueName(), str, bool1, bool2);
        }
        else if ((paramObject instanceof SheetFieldMapping))
        {
          localObject = ((SheetFieldMapping)paramObject).getMemberElement();
          if ((localObject instanceof IBusinessObject))
            return j.a(this.a, ((IBusinessObject)localObject).getValueName(), str, bool1, bool2);
          localObject = ((SheetFieldMapping)paramObject).getMappingField();
          if ((localObject instanceof IBusinessObject))
            return j.a(this.a, ((IBusinessObject)localObject).getValueName(), str, bool1, bool2);
        }
      }
      else if ((this.b.h()) && ((paramObject instanceof ILineEditen)))
        return j.a(this.a, ((ILineEditen)paramObject).toString(), str, bool1, bool2);
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return !(paramObject instanceof Envionment);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.k
 * JD-Core Version:    0.6.0
 */