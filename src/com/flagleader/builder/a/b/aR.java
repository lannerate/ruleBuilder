package com.flagleader.builder.a.b;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.d.c;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.MappingVariable;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;

public class aR extends e
{
  public static String[] q = new String[4];

  static
  {
    q[0] = c.b("none.ValueLibraryEditor");
    q[1] = c.b("in.ValueLibraryEditor");
    q[2] = c.b("out.ValueLibraryEditor");
    q[3] = c.b("inout.ValueLibraryEditor");
  }

  public aR(IBusinessObjectContainer paramIBusinessObjectContainer, Composite paramComposite, bu parambu)
  {
    super(paramIBusinessObjectContainer, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new aR((IBusinessObjectContainer)this.c, paramComposite, this.a);
  }

  protected void a(CCombo paramCCombo, int paramInt)
  {
    if (paramInt == 5)
      paramCCombo.setItems(q);
    super.a(paramCCombo, paramInt);
  }

  protected String[] o()
  {
    String[] arrayOfString1 = super.o();
    String[] arrayOfString2 = new String[arrayOfString1.length + 1];
    System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, arrayOfString1.length);
    arrayOfString2[arrayOfString1.length] = "100";
    return arrayOfString2;
  }

  protected String[] n()
  {
    String[] arrayOfString1 = super.n();
    String[] arrayOfString2 = new String[arrayOfString1.length + 1];
    System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, arrayOfString1.length);
    arrayOfString2[arrayOfString1.length] = c.b("outtype.ValueLibraryEditor");
    return arrayOfString2;
  }

  protected boolean a(IElement paramIElement, int paramInt, String paramString)
  {
    if ((paramInt == 5) && (paramIElement != null) && ((paramIElement instanceof MappingVariable)))
    {
      MappingVariable localMappingVariable = (MappingVariable)paramIElement;
      if (!q[localMappingVariable.getInout()].equals(paramString))
      {
        localMappingVariable.getContainer().initUndoable();
        for (int i = 0; i < q.length; i++)
        {
          if (!q[i].equals(paramString))
            continue;
          localMappingVariable.setInout(i);
          localMappingVariable.getContainer().setModified(true);
          localMappingVariable.getContainer().takeSnapshot();
          return true;
        }
      }
      return false;
    }
    return super.a(paramIElement, paramInt, paramString);
  }

  protected int a(int paramInt, IElement paramIElement)
  {
    if ((paramIElement == null) || (K().isLocked()))
    {
      if ((paramInt == 0) && (K().canCreateEditen()))
        return 1;
    }
    else if ((paramIElement instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramIElement;
      if ((paramInt == 0) && (localIBusinessObjectEditen.isValueEditable()))
        return 1;
      if (paramInt == 2)
        return 1;
      if ((paramInt == 1) && (localIBusinessObjectEditen.isTypeEditable()))
        return 2;
      if ((paramInt == 3) && (localIBusinessObjectEditen.isGroupEditable()))
        return 1;
      if ((paramInt == 5) && ((localIBusinessObjectEditen instanceof MappingVariable)))
        return 2;
    }
    return 0;
  }

  protected String[] a(IElement paramIElement)
  {
    if ((paramIElement instanceof MappingVariable))
    {
      MappingVariable localMappingVariable = (MappingVariable)paramIElement;
      return new String[] { localMappingVariable.getValueName(), localMappingVariable.getValueType(), localMappingVariable.getDisplayName(), localMappingVariable.getShowGroupName(), localMappingVariable.getVarValue(), q[localMappingVariable.getInout()] };
    }
    return super.a(paramIElement);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aR
 * JD-Core Version:    0.6.0
 */