package com.flagleader.builder;

import com.flagleader.manager.d.c;
import com.flagleader.repository.IElement;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleMirror;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;
import com.flagleader.util.prefs.Messages;
import com.flagleader.util.prefs.Preferences;
import com.flagleader.util.prefs.PropertyBundle;
import java.util.HashMap;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public final class ResourceTools
{
  public static String resourceLoc = "builder";
  private static HashMap a = new HashMap();
  private static HashMap b = new HashMap();
  private static HashMap c = new HashMap();
  private static HashMap d = new HashMap();
  private static PropertyBundle e = Messages.getMessages().getPropertyBundle(resourceLoc);
  private static PropertyBundle f = Preferences.getPreferences().getPropertyBundle(resourceLoc);

  public static Image getImage(String paramString)
  {
    if (!a.containsKey(paramString))
    {
      String str = getStringValue(paramString);
      if (str != null)
      {
        ImageDescriptor localImageDescriptor = ImageDescriptor.createFromURL(ResourceTools.class.getClassLoader().getResource(str));
        a.put(paramString, localImageDescriptor.createImage());
      }
      else
      {
        a.put(paramString, ImageDescriptor.getMissingImageDescriptor().createImage());
      }
    }
    return (Image)a.get(paramString);
  }

  public static Image getDisableImage(String paramString)
  {
    if (!c.containsKey(paramString))
    {
      String str = getStringValue(paramString);
      if (str != null)
      {
        ImageDescriptor localImageDescriptor = ImageDescriptor.createFromURL(ResourceTools.class.getClassLoader().getResource(str));
        c.put(paramString, ImageDescriptor.createWithFlags(localImageDescriptor, 1).createImage());
      }
      else
      {
        c.put(paramString, ImageDescriptor.getMissingImageDescriptor().createImage());
      }
    }
    return (Image)c.get(paramString);
  }

  public static Image getGrayImage(String paramString)
  {
    if (!d.containsKey(paramString))
    {
      String str = getStringValue(paramString);
      if (str != null)
      {
        ImageDescriptor localImageDescriptor = ImageDescriptor.createFromURL(ResourceTools.class.getClassLoader().getResource(str));
        d.put(paramString, ImageDescriptor.createWithFlags(localImageDescriptor, 2).createImage());
      }
      else
      {
        d.put(paramString, ImageDescriptor.getMissingImageDescriptor().createImage());
      }
    }
    return (Image)d.get(paramString);
  }

  public static ImageDescriptor getImageDescriptor(String paramString)
  {
    if (!b.containsKey(paramString))
    {
      String str = getStringValue(paramString);
      if (str != null)
      {
        ImageDescriptor localImageDescriptor = ImageDescriptor.createFromURL(ResourceTools.class.getClassLoader().getResource(str));
        b.put(paramString, localImageDescriptor);
      }
      else
      {
        b.put(paramString, ImageDescriptor.getMissingImageDescriptor());
      }
    }
    return (ImageDescriptor)b.get(paramString);
  }

  public static Image getIcon(ITreeNode paramITreeNode)
  {
    String str = paramITreeNode.getName();
    if (((paramITreeNode instanceof RuleMirror)) && (((RuleMirror)paramITreeNode).getMemberElement() != null))
      str = ((RuleMirror)paramITreeNode).getMemberElement().getName();
    if (((paramITreeNode instanceof SheetTable)) && (((SheetTable)paramITreeNode).isSaveValue()))
      str = str + "2";
    else if (((paramITreeNode instanceof TreeValueNode)) && (!((TreeValueNode)paramITreeNode).isSingleValue()))
      str = str + "2";
    if ((paramITreeNode instanceof XmlNode))
      if (((XmlNode)paramITreeNode).isRootElement())
        str = "firstxml";
      else if ((((XmlNode)paramITreeNode).getMultiType() == 3) || (((XmlNode)paramITreeNode).getMultiType() == 2))
        str = "xmlNode2";
    Image localImage = getImage(str + ".icon");
    if (paramITreeNode.isLocked())
      localImage = getGrayImage(str + ".icon");
    else if (((paramITreeNode instanceof IRuleTree)) && (!((IRuleTree)paramITreeNode).isActived()))
      localImage = getDisableImage(str + ".icon");
    return localImage;
  }

  public static String getMessage(String paramString)
  {
    return c.b(paramString);
  }

  public static String formatMessage(String paramString, Object[] paramArrayOfObject)
  {
    return c.a(paramString, paramArrayOfObject);
  }

  public static String getMessage(String paramString1, String paramString2)
  {
    return c.a(paramString1, paramString2);
  }

  public static String[] getConfigArray(String paramString)
  {
    return c.e(paramString);
  }

  public static String[] getStringArray(String paramString)
  {
    return c.d(paramString);
  }

  public static String getStringValue(String paramString)
  {
    return c.c(paramString);
  }

  public static int getIntValue(String paramString, int paramInt)
  {
    return c.a(paramString, paramInt);
  }

  public static void setPbundle(PropertyBundle paramPropertyBundle)
  {
    f = paramPropertyBundle;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.ResourceTools
 * JD-Core Version:    0.6.0
 */