package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionMultiRule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class i
  implements e
{
  private List b = null;
  private int c = -1;
  private int d = 0;

  public int a()
  {
    for (int i = 0; i < this.b.size(); i++)
    {
      if ((this.a.f().getDecisionElement(this.d) == null) || (!this.b.get(i).equals(this.a.f().getDecisionElement(this.d).getMemberElement())))
        continue;
      this.c = i;
    }
    if (this.a.f().getDecisionElement(this.d) != null)
      this.c = 0;
    return this.c;
  }

  public String[] b()
  {
    Object localObject;
    if ((this.a.f().getDecisionElement(this.d) != null) && (this.a.f().getDecisionElement(this.d).getMemberElement() != null))
    {
      arrayOfString = new String[this.b.size() + 1];
      arrayOfString[0] = this.a.f().getDecisionElement(this.d).getMemberElement().getShowDisplayName();
      for (i = 0; i < this.b.size(); i++)
      {
        localObject = this.b.get(i);
        if ((localObject instanceof IPropertyObject))
          arrayOfString[(i + 1)] = (((IPropertyObject)localObject).getDisplayName() + "  " + ((IPropertyObject)localObject).getValueName() + "  " + ((IPropertyObject)localObject).getParent().getDisplayName());
        else if ((localObject instanceof IVariableObject))
          arrayOfString[(i + 1)] = (((IVariableObject)localObject).getDisplayName() + "  " + ((IVariableObject)localObject).getValueName() + "  ");
        else
          arrayOfString[(i + 1)] = this.b.get(i).toString();
      }
      return arrayOfString;
    }
    String[] arrayOfString = new String[this.b.size()];
    for (int i = 0; i < this.b.size(); i++)
    {
      localObject = this.b.get(i);
      if ((localObject instanceof IPropertyObject))
        arrayOfString[i] = (((IPropertyObject)localObject).getDisplayName() + "  " + ((IPropertyObject)localObject).getValueName() + "  " + ((IPropertyObject)localObject).getParent().getDisplayName());
      else if ((localObject instanceof IVariableObject))
        arrayOfString[i] = (((IVariableObject)localObject).getDisplayName() + "  " + ((IVariableObject)localObject).getValueName() + "  ");
      else
        arrayOfString[i] = this.b.get(i).toString();
    }
    return arrayOfString;
  }

  public boolean a(int paramInt)
  {
    if ((this.a.f().getDecisionElement(this.d) != null) && (this.a.f().getDecisionElement(this.d).getMemberElement() != null))
    {
      if ((this.c != paramInt) && (this.b != null) && (this.b.get(paramInt - 1) != null) && ((this.b.get(paramInt - 1) instanceof IBusinessObject)) && (this.a.f().setDecisionElement(this.d, (IBusinessObject)this.b.get(paramInt - 1))))
      {
        this.a.f().updateViewer();
        this.a.f().setModified(true);
        return true;
      }
    }
    else if ((this.c != paramInt) && (this.b != null) && (this.b.get(paramInt) != null) && ((this.b.get(paramInt) instanceof IBusinessObject)) && (this.a.f().setDecisionElement(this.d, (IBusinessObject)this.b.get(paramInt))))
    {
      this.a.f().updateViewer();
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }

  public i(g paramg, int paramInt)
  {
    this.d = paramInt;
    if (this.b == null)
      this.b = new ArrayList();
    else
      this.b.clear();
    Iterator localIterator = paramg.f().getAviableMembers();
    while (localIterator.hasNext())
      this.b.add(localIterator.next());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.i
 * JD-Core Version:    0.6.0
 */