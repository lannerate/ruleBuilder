package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.xml.XmlAttribute;
import com.flagleader.repository.xml.XmlNode;
import java.io.File;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.jdom.Attribute;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class q extends bl
{
  public q(BuilderManager paramBuilderManager)
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
          XmlNode localXmlNode = new XmlNode();
          localXmlNode.setNodeName(localElement.getName());
          if ((localElement.getChildren().size() == 0) && (localElement.getText() != null) && (localElement.getText().length() > 0))
            localXmlNode.setDisplayName(localElement.getText());
          else
            localXmlNode.setDisplayName(localElement.getName());
          ((Envionment)paramITreeNode).addChildElement(localXmlNode);
          localXmlNode.updateFunction();
          a(localElement, localXmlNode);
          localXmlNode.setModified(true);
          ((Envionment)paramITreeNode).updateTree();
        }
        catch (Exception localException)
        {
          MessageDialog.openError(this.a.getShell(), "", localException.getLocalizedMessage());
        }
      }
    }
  }

  private XmlNode a(Element paramElement, XmlNode paramXmlNode)
  {
    List localList1 = paramElement.getAttributes();
    for (int i = 0; i < localList1.size(); i++)
    {
      localObject = (Attribute)localList1.get(i);
      paramXmlNode.addChildElement(new XmlAttribute(((Attribute)localObject).getName(), "string", ((Attribute)localObject).getValue()));
    }
    List localList2 = paramElement.getContent();
    Object localObject = "";
    for (int j = 0; j < localList2.size(); j++)
      if ((localList2.get(j) instanceof Comment))
      {
        localObject = ((Comment)localList2.get(j)).getText().trim();
      }
      else
      {
        if (!(localList2.get(j) instanceof Element))
          continue;
        Element localElement = (Element)localList2.get(j);
        XmlNode localXmlNode = new XmlNode();
        localXmlNode.setNodeName(localElement.getName());
        localXmlNode.setMultiType(1);
        if (((String)localObject).length() > 0)
          localXmlNode.setDisplayName((String)localObject);
        else if ((localElement.getChildren().size() == 0) && (localElement.getText() != null) && (localElement.getText().length() > 0))
          localXmlNode.setDisplayName(localElement.getText());
        else
          localXmlNode.setDisplayName(localElement.getName());
        paramXmlNode.addChildElement(localXmlNode);
        a((Element)localList2.get(j), localXmlNode);
        localXmlNode.updateFunction();
        localObject = "";
      }
    return (XmlNode)paramXmlNode;
  }

  protected boolean d()
  {
    return true;
  }

  public String a()
  {
    return "LoadXmlNodeItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof Envionment;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.q
 * JD-Core Version:    0.6.0
 */