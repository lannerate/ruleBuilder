package com.flagleader.builder.a.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.p;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.xml.XmlAttribute;
import com.flagleader.repository.xml.XmlNode;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;

public class aS extends e
  implements IElementViewer
{
  public aS(XmlNode paramXmlNode, Composite paramComposite, bu parambu)
  {
    super(paramXmlNode, paramComposite, parambu);
  }

  protected com.flagleader.builder.a.aS e(Composite paramComposite)
  {
    return new aS((XmlNode)this.c, paramComposite, this.a);
  }

  protected void a(CCombo paramCCombo, int paramInt)
  {
    super.a(paramCCombo, paramInt);
  }

  protected String[] o()
  {
    return ResourceTools.getStringArray("lengths.XmlAttributesEditor");
  }

  protected String[] n()
  {
    String[] arrayOfString = ResourceTools.getStringArray("columns.XmlAttributesEditor");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (ResourceTools.getMessage(arrayOfString[i] + ".XmlAttributesEditor") == null)
        continue;
      arrayOfString[i] = ResourceTools.getMessage(arrayOfString[i] + ".XmlAttributesEditor");
    }
    return arrayOfString;
  }

  protected String[] E()
  {
    return XmlAttribute.DATETYPES;
  }

  protected boolean a(IElement paramIElement, int paramInt, String paramString)
  {
    if (paramIElement == null)
    {
      if ((K().canCreateEditen()) && (paramString.length() > 0))
        try
        {
          K().initUndoable();
          XmlAttribute localXmlAttribute = F().addAttribute(paramString, "string", paramString);
          localXmlAttribute.setVisible(true);
          K().takeSnapshot();
          K().setModified(true);
          localXmlAttribute.update();
          return true;
        }
        catch (p localp)
        {
          Logger.getLogger("flagleader").log(Level.SEVERE, paramString + localp.getMessage());
          return false;
        }
      return true;
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
    }
    return 0;
  }

  protected String[] a(IElement paramIElement)
  {
    if ((paramIElement instanceof XmlAttribute))
    {
      XmlAttribute localXmlAttribute = (XmlAttribute)paramIElement;
      return new String[] { localXmlAttribute.getValueName(), localXmlAttribute.getValueType(), localXmlAttribute.getDisplayName(), localXmlAttribute.getShowGroupName(), localXmlAttribute.getVarValue() };
    }
    return super.a(paramIElement);
  }

  protected void t()
  {
    Iterator localIterator = K().getEditens();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof XmlAttribute)) || ((b()) && (!((IBusinessObjectEditen)localObject).isVisible())))
        continue;
      Item localItem = d(null);
      localItem.setData(localObject);
      a(localItem, (IBusinessObjectEditen)localObject);
    }
    if (K().canCreateEditen())
      d(null);
  }

  protected XmlNode F()
  {
    return (XmlNode)this.c;
  }

  protected void D()
  {
    y localy = G();
    if ((localy.open() == 0) && (localy.a().length() > 0))
      try
      {
        K().initUndoable();
        XmlAttribute localXmlAttribute = F().addAttribute(localy.a(), localy.c(), localy.b());
        localXmlAttribute.setVisible(true);
        K().takeSnapshot();
        localXmlAttribute.update();
        K().setModified(true);
      }
      catch (Exception localException)
      {
        Logger.getLogger("flagleader").log(Level.SEVERE, localy.a() + localException.getMessage());
      }
  }

  protected y G()
  {
    return new aT(this);
  }

  public String getCompositeUuid()
  {
    return super.getCompositeUuid() + "props";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aS
 * JD-Core Version:    0.6.0
 */