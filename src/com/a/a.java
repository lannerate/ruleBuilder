package com.a;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class a extends c
{
  private static HashMap e = new HashMap();
  private static HashMap f = new HashMap();
  private static HashMap g = new HashMap();

  public static void a()
  {
    c();
    d();
    b();
    e();
  }

  public static ImageDescriptor a(Class paramClass, String paramString)
  {
    return ImageDescriptor.createFromFile(paramClass, paramString);
  }

  public static ImageDescriptor a(String paramString)
  {
    try
    {
      return ImageDescriptor.createFromURL(new File(paramString).toURI().toURL());
    }
    catch (MalformedURLException localMalformedURLException)
    {
    }
    return null;
  }

  public static Image a(ImageDescriptor paramImageDescriptor)
  {
    if (paramImageDescriptor == null)
      return null;
    Image localImage = (Image)e.get(paramImageDescriptor);
    if (localImage == null)
    {
      localImage = paramImageDescriptor.createImage();
      e.put(paramImageDescriptor, localImage);
    }
    return localImage;
  }

  public static Image a(Image paramImage1, Image paramImage2, int paramInt)
  {
    HashMap localHashMap = (HashMap)f.get(paramImage1);
    if (localHashMap == null)
    {
      localHashMap = new HashMap();
      f.put(paramImage1, localHashMap);
    }
    Image localImage = (Image)localHashMap.get(paramImage2);
    if (localImage == null)
    {
      Rectangle localRectangle1 = paramImage1.getBounds();
      Rectangle localRectangle2 = paramImage2.getBounds();
      Point localPoint = new Point(localRectangle1.width, localRectangle1.height);
      b localb = new b(paramImage1, paramInt, paramImage2, localRectangle1, localRectangle2, localPoint);
      localImage = localb.createImage();
      localHashMap.put(paramImage2, localImage);
    }
    return localImage;
  }

  public static void b()
  {
    c.b();
    Iterator localIterator = e.values().iterator();
    while (localIterator.hasNext())
      ((Image)localIterator.next()).dispose();
    e.clear();
    localIterator = g.values().iterator();
    while (localIterator.hasNext())
      ((Image)localIterator.next()).dispose();
    g.clear();
  }

  public static Image a(Object paramObject, String paramString)
  {
    try
    {
      URL localURL = c(paramObject, paramString);
      if (g.containsKey(localURL))
        return (Image)g.get(localURL);
      InputStream localInputStream = localURL.openStream();
      Image localImage;
      try
      {
        localImage = a(localInputStream);
        g.put(localURL, localImage);
      }
      finally
      {
        localInputStream.close();
      }
      return localImage;
    }
    catch (Throwable localThrowable1)
    {
    }
    catch (Throwable localThrowable2)
    {
    }
    return null;
  }

  public static ImageDescriptor b(Object paramObject, String paramString)
  {
    try
    {
      URL localURL = c(paramObject, paramString);
      return ImageDescriptor.createFromURL(localURL);
    }
    catch (Throwable localThrowable1)
    {
    }
    catch (Throwable localThrowable2)
    {
    }
    return null;
  }

  private static URL c(Object paramObject, String paramString)
  {
    try
    {
      Class localClass1 = Class.forName("org.osgi.framework.Bundle");
      localClass3 = Class.forName("org.osgi.framework.BundleContext");
      if (localClass3.isAssignableFrom(paramObject.getClass()))
      {
        localObject1 = localClass3.getMethod("getBundle", new Class[0]);
        localObject2 = ((Method)localObject1).invoke(paramObject, new Object[0]);
        localObject3 = Class.forName("org.eclipse.core.runtime.IPath");
        localObject4 = Class.forName("org.eclipse.core.runtime.Path");
        Constructor localConstructor = ((Class)localObject4).getConstructor(new Class[] { String.class });
        Object localObject5 = localConstructor.newInstance(new Object[] { paramString });
        Class localClass4 = Class.forName("org.eclipse.core.runtime.Platform");
        Method localMethod = localClass4.getMethod("find", new Class[] { localClass1, localObject3 });
        return (URL)localMethod.invoke(null, new Object[] { localObject2, localObject5 });
      }
    }
    catch (Throwable localClass2)
    {
      Class localClass3;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Class localClass2 = Class.forName("org.eclipse.core.runtime.Plugin");
      if (localClass2.isAssignableFrom(paramObject.getClass()))
      {
        localClass3 = Class.forName("org.eclipse.core.runtime.IPath");
        localObject1 = Class.forName("org.eclipse.core.runtime.Path");
        localObject2 = ((Class)localObject1).getConstructor(new Class[] { String.class });
        localObject3 = ((Constructor)localObject2).newInstance(new Object[] { paramString });
        localObject4 = localClass2.getMethod("find", new Class[] { localClass3 });
        return (URL)((Method)localObject4).invoke(paramObject, new Object[] { localObject3 });
      }
    }
    return (URL)(URL)(URL)(URL)null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.a.a
 * JD-Core Version:    0.6.0
 */