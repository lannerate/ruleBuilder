package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import java.io.File;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.jdom.Attribute;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class n extends bl
{
  public n(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    String[] arrayOfString = { "*.xml" };
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof Envionment)))
    {
      FileDialog localFileDialog = new FileDialog(this.a.getShell());
      localFileDialog.setFilterExtensions(arrayOfString);
      String str = localFileDialog.open();
      if (str != null)
      {
        File localFile = new File(str);
        SAXBuilder localSAXBuilder = new SAXBuilder();
        try
        {
          Document localDocument = localSAXBuilder.build(localFile);
          Element localElement = localDocument.getRootElement();
          TreeValueNode localTreeValueNode = new TreeValueNode();
          localTreeValueNode.setNodeName(localElement.getName());
          if ((localElement.getChildren().size() == 0) && (localElement.getText() != null) && (localElement.getText().length() > 0))
            localTreeValueNode.setDisplayName(localElement.getText());
          else
            localTreeValueNode.setDisplayName(localElement.getName());
          ((Envionment)paramITreeNode).addChildElement(localTreeValueNode);
          localTreeValueNode.resetFunction();
          a(localElement, localTreeValueNode);
          localTreeValueNode.setModified(true);
          ((Envionment)paramITreeNode).updateTree();
        }
        catch (Exception localException)
        {
          MessageDialog.openError(this.a.getShell(), "", localException.getLocalizedMessage());
        }
      }
    }
  }

  private TreeValueNode a(Element paramElement, TreeValueNode paramTreeValueNode)
  {
    List localList1 = paramElement.getAttributes();
    for (int i = 0; i < localList1.size(); i++)
    {
      localObject1 = (Attribute)localList1.get(i);
      paramTreeValueNode.addChildElement(new TreeAttribute(((Attribute)localObject1).getName(), "string", ((Attribute)localObject1).getValue(), 1));
    }
    List localList2 = paramElement.getContent();
    Object localObject1 = "";
    for (int j = 0; j < localList2.size(); j++)
      if ((localList2.get(j) instanceof Comment))
      {
        localObject1 = ((Comment)localList2.get(j)).getText().trim();
      }
      else
      {
        if (!(localList2.get(j) instanceof Element))
          continue;
        Element localElement = (Element)localList2.get(j);
        Object localObject2;
        if ((localElement.getChildren().size() == 0) && (localElement.getAttributes().size() == 0))
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() == 0)
            localObject2 = localElement.getText();
          TreeAttribute localTreeAttribute = paramTreeValueNode.getAttribute(localElement.getName());
          if (localTreeAttribute == null)
          {
            localTreeAttribute = new TreeAttribute(localElement.getName(), "string", (String)localObject2, 0);
            paramTreeValueNode.addChildElement(localTreeAttribute);
          }
          else
          {
            localTreeAttribute.setValueType("string[]");
          }
        }
        else
        {
          localObject2 = paramTreeValueNode.getSubTreeNode(localElement.getName());
          if (localObject2 == null)
          {
            localObject2 = new TreeValueNode();
            ((TreeValueNode)localObject2).setNodeName(localElement.getName());
            ((TreeValueNode)localObject2).setMultiType(0);
            if (((String)localObject1).length() > 0)
              ((TreeValueNode)localObject2).setDisplayName((String)localObject1);
            else if ((localElement.getChildren().size() == 0) && (localElement.getText() != null) && (localElement.getText().length() > 0))
              ((TreeValueNode)localObject2).setDisplayName(localElement.getText());
            else
              ((TreeValueNode)localObject2).setDisplayName(localElement.getName());
            paramTreeValueNode.addChildElement((IElement)localObject2);
            a((Element)localList2.get(j), (TreeValueNode)localObject2);
            ((TreeValueNode)localObject2).resetFunction();
          }
          else
          {
            ((TreeValueNode)localObject2).setMultiType(1);
          }
        }
        localObject1 = "";
      }
    return (TreeValueNode)(TreeValueNode)paramTreeValueNode;
  }

  protected boolean d()
  {
    return true;
  }

  public String a()
  {
    return "LoadTreeValueItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof Envionment;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.n
 * JD-Core Version:    0.6.0
 */