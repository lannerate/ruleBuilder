package com.flagleader.repository.e;

import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

public class t extends e
{
  public t(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public t(Writer paramWriter)
  {
    super(paramWriter);
  }

  public t(File paramFile)
  {
    super(paramFile);
  }

  protected void a(IElement paramIElement)
  {
    Iterator localIterator = paramIElement.getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject == null) || ((localObject instanceof ITreeNode)))
        continue;
      ((IElement)localObject).acceptVisitor(this);
    }
  }

  private void c(ITreeNode paramITreeNode)
  {
    String[] arrayOfString = { "displayName", paramITreeNode.getDisplayName(), "nametype", paramITreeNode.getName(), "modifyTime", paramITreeNode.getModifyTime(), "uuid", paramITreeNode.getUuid() };
    openMarkerLn("ChildNodeInfo", arrayOfString);
    closeMarkerLn("ChildNodeInfo");
  }

  public void a(ITreeNode paramITreeNode)
  {
    printHeader();
    String[] arrayOfString = { "displayName", paramITreeNode.getDisplayName(), "modifyTime", paramITreeNode.getModifyTime(), "uuid", paramITreeNode.getUuid() };
    openMarkerLn("ParentInfo", arrayOfString);
    paramITreeNode.acceptVisitor(this);
    Iterator localIterator = paramITreeNode.getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject == null) || (!(localObject instanceof ITreeNode)))
        continue;
      c((ITreeNode)localObject);
    }
    closeMarkerLn("ParentInfo");
    flush();
  }

  public static void a(ITreeNode paramITreeNode, File paramFile)
  {
    t localt = new t(paramFile);
    localt.a(paramITreeNode);
    localt.close();
  }

  public static String b(ITreeNode paramITreeNode)
  {
    StringWriter localStringWriter = new StringWriter();
    t localt = new t(new PrintWriter(localStringWriter));
    localt.a(paramITreeNode);
    return localStringWriter.toString();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.t
 * JD-Core Version:    0.6.0
 */