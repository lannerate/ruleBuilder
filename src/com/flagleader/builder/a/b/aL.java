package com.flagleader.builder.a.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.p;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;

public class aL extends e
  implements IElementViewer
{
  public static String[] q = ResourceTools.getStringArray("locates.TreeValueAttributesEditor");

  static
  {
    for (int i = 0; i < q.length; i++)
    {
      if (ResourceTools.getMessage(q[i] + ".TreeValueAttributesEditor") == null)
        continue;
      q[i] = ResourceTools.getMessage(q[i] + ".TreeValueAttributesEditor");
    }
  }

  public aL(TreeValueNode paramTreeValueNode, Composite paramComposite, bu parambu)
  {
    super(paramTreeValueNode, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new aL((TreeValueNode)this.c, paramComposite, this.a);
  }

  protected String[] o()
  {
    return ResourceTools.getStringArray("lengths.TreeValueAttributesEditor");
  }

  protected String[] n()
  {
    String[] arrayOfString = ResourceTools.getStringArray("columns.TreeValueAttributesEditor");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (ResourceTools.getMessage(arrayOfString[i] + ".TreeValueAttributesEditor") == null)
        continue;
      arrayOfString[i] = ResourceTools.getMessage(arrayOfString[i] + ".TreeValueAttributesEditor");
    }
    return arrayOfString;
  }

  protected boolean r()
  {
    return true;
  }

  protected String[] p()
  {
    return ResourceTools.getStringArray("types.TreeValueAttributesEditor");
  }

  protected String[] E()
  {
    return TreeAttribute.DATETYPES;
  }

  protected void a(CCombo paramCCombo, int paramInt)
  {
    if (paramInt == 4)
      paramCCombo.setItems(q);
    super.a(paramCCombo, paramInt);
  }

  protected boolean a(IElement paramIElement, int paramInt, String paramString)
  {
    if (paramIElement == null)
    {
      if ((K().canCreateEditen()) && (paramString.length() > 0))
        try
        {
          K().initUndoable();
          TreeAttribute localTreeAttribute1 = F().addAttribute(paramString, "string", paramString);
          localTreeAttribute1.setVisible(true);
          K().takeSnapshot();
          K().setModified(true);
          localTreeAttribute1.update();
          return true;
        }
        catch (p localp)
        {
          Logger.getLogger("flagleader").log(Level.SEVERE, paramString + localp.getMessage());
          return false;
        }
      return true;
    }
    if (paramInt == 4)
    {
      TreeAttribute localTreeAttribute2 = (TreeAttribute)paramIElement;
      if (!q[localTreeAttribute2.getLocate()].equals(paramString))
      {
        K().initUndoable();
        for (int i = 0; i < q.length; i++)
        {
          if (!q[i].equals(paramString))
            continue;
          localTreeAttribute2.setLocate(i);
        }
        localTreeAttribute2.getContainer().setModified(true);
        K().takeSnapshot();
        return true;
      }
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
      if (paramInt == 4)
        return 2;
      if ((paramInt == 3) && (localIBusinessObjectEditen.isGroupEditable()))
        return 1;
    }
    return 0;
  }

  protected String[] a(IElement paramIElement)
  {
    if ((paramIElement instanceof TreeAttribute))
    {
      TreeAttribute localTreeAttribute = (TreeAttribute)paramIElement;
      return new String[] { localTreeAttribute.getValueName(), localTreeAttribute.getValueType(), localTreeAttribute.getDisplayName(), localTreeAttribute.getShowGroupName(), q[localTreeAttribute.getLocate()] };
    }
    return super.a(paramIElement);
  }

  protected void t()
  {
    Iterator localIterator = K().getEditens();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof TreeAttribute)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
        continue;
      Item localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (IBusinessObjectEditen)localObject);
    }
    if (K().canCreateEditen())
      d(null);
  }

  protected TreeValueNode F()
  {
    return (TreeValueNode)this.c;
  }

  protected void D()
  {
    aM localaM = (aM)G();
    if (localaM.open() == 0)
      try
      {
        K().initUndoable();
        TreeAttribute localTreeAttribute = F().addAttribute(localaM.a(), localaM.c(), localaM.b(), localaM.d());
        localTreeAttribute.setVisible(true);
        K().takeSnapshot();
        localTreeAttribute.update();
        K().setModified(true);
      }
      catch (Exception localException)
      {
        Logger.getLogger("flagleader").log(Level.SEVERE, localaM.a() + localException.getMessage());
      }
  }

  protected y G()
  {
    return new aM(this);
  }

  public String getCompositeUuid()
  {
    return super.getCompositeUuid() + "props";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aL
 * JD-Core Version:    0.6.0
 */