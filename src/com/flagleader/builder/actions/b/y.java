package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.excel.ExcelSheetModel;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.InterfaceContainer;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;

public class y extends bl
{
  public y(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()))
    {
      Object localObject;
      if ((paramITreeNode instanceof SheetTable))
      {
        localObject = (SheetTable)paramITreeNode;
        ((SheetTable)localObject).updateFunction();
        ((SheetTable)localObject).setModified(true);
        ((SheetTable)localObject).updateViewer();
      }
      else if ((paramITreeNode instanceof ExcelBookModel))
      {
        localObject = (ExcelBookModel)paramITreeNode;
        ((ExcelBookModel)localObject).updateFunction();
        ((ExcelBookModel)localObject).setModified(true);
        ((ExcelBookModel)localObject).updateViewer();
      }
      else if ((paramITreeNode instanceof ExcelSheetModel))
      {
        localObject = (ExcelSheetModel)paramITreeNode;
        ((ExcelSheetModel)localObject).updateFunction();
        ((ExcelSheetModel)localObject).setModified(true);
        ((ExcelSheetModel)localObject).updateViewer();
      }
      else if ((paramITreeNode instanceof ISelectObject))
      {
        localObject = (ISelectObject)paramITreeNode;
        ((ISelectObject)localObject).updateFunction();
        ((ISelectObject)localObject).setModified(true);
        ((ISelectObject)localObject).updateViewer();
      }
      else if ((paramITreeNode instanceof XmlNode))
      {
        localObject = (XmlNode)paramITreeNode;
        ((XmlNode)localObject).updateFunction();
        ((XmlNode)localObject).setModified(true);
        ((XmlNode)localObject).updateViewer();
      }
      else if ((paramITreeNode instanceof TreeValueNode))
      {
        localObject = (TreeValueNode)paramITreeNode;
        ((TreeValueNode)localObject).resetFunction();
        ((TreeValueNode)localObject).setModified(true);
        ((TreeValueNode)localObject).updateViewer();
      }
      else if ((paramITreeNode instanceof SoapService))
      {
        localObject = (SoapService)paramITreeNode;
        ((SoapService)localObject).updateFunction();
        ((SoapService)localObject).setModified(true);
        ((SoapService)localObject).updateViewer();
      }
      else if ((paramITreeNode instanceof SheetMap))
      {
        localObject = (SheetMap)paramITreeNode;
        ((SheetMap)localObject).updateFunction();
        ((SheetMap)localObject).setModified(true);
        ((SheetMap)localObject).updateViewer();
      }
      else if ((paramITreeNode instanceof ClassContainer))
      {
        localObject = (ClassContainer)paramITreeNode;
        ((ClassContainer)localObject).resetFunction();
        ((ClassContainer)localObject).setModified(true);
        ((ClassContainer)localObject).updateViewer();
      }
      else if ((paramITreeNode instanceof InterfaceContainer))
      {
        localObject = (InterfaceContainer)paramITreeNode;
        ((InterfaceContainer)localObject).resetFunction();
        ((InterfaceContainer)localObject).setModified(true);
        ((InterfaceContainer)localObject).updateViewer();
      }
    }
  }

  public String a()
  {
    return "UpdateSheetFunction";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof SheetTable)) || ((paramITreeNode instanceof ExcelSheetModel)) || ((paramITreeNode instanceof ISelectObject)) || ((paramITreeNode instanceof TreeValueNode)) || ((paramITreeNode instanceof XmlNode)) || ((paramITreeNode instanceof ExcelBookModel)) || ((paramITreeNode instanceof SoapService)) || ((paramITreeNode instanceof ClassContainer)) || ((paramITreeNode instanceof InterfaceContainer)) || ((paramITreeNode instanceof SheetMap));
  }

  protected boolean d()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.y
 * JD-Core Version:    0.6.0
 */