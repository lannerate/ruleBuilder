package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetAndFieldEditen;
import com.flagleader.repository.rlm.value.SheetFieldMapping;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.List;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;

class am
  implements TraverseListener
{
  am(Y paramY, CCombo paramCCombo, TableItem paramTableItem, int paramInt, List paramList)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 4) || (paramTraverseEvent.detail == 16))
    {
      if (this.b.getSelectionIndex() >= 0)
      {
        SheetFieldMapping localSheetFieldMapping = (SheetFieldMapping)this.c.getData();
        if (this.d == 0)
          localSheetFieldMapping.setMappingField((IBusinessObject)this.e.get(this.b.getSelectionIndex()));
        else
          localSheetFieldMapping.setField((IBusinessObject)Y.m(this.a).get(this.b.getSelectionIndex()));
        this.c.setText(0, localSheetFieldMapping.getMappingField().getDisplayName() + "-" + localSheetFieldMapping.getMappingField().getValueName() + "-" + localSheetFieldMapping.getMappingField().getValueType());
        this.c.setText(1, localSheetFieldMapping.getField().getDisplayName());
        this.c.setText(2, localSheetFieldMapping.getField().getValueType());
        this.c.setText(3, localSheetFieldMapping.getField().getValueName());
        Y.a(this.a).getRoot().setModified(true);
      }
      this.b.dispose();
      Y.n(this.a).setEditor(null, null, -1);
    }
    if (paramTraverseEvent.detail == 2)
    {
      this.b.dispose();
      Y.n(this.a).setEditor(null, null, -1);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.am
 * JD-Core Version:    0.6.0
 */